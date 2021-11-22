package com.naturalmotion.webservice.api;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.CRC32;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naturalmotion.webservice.service.Crew;
import com.naturalmotion.webservice.service.CrewChat;
import com.naturalmotion.webservice.service.CrewChatService;
import com.naturalmotion.webservice.service.CrewService;
import com.naturalmotion.webservice.service.ProfileBodyParam;
import com.naturalmotion.webservice.service.auth.Authorization;
import com.naturalmotion.webservice.service.json.Card;
import com.naturalmotion.webservice.service.json.CrewBodyParam;
import com.naturalmotion.webservice.service.json.Leaderbord;
import com.naturalmotion.webservice.service.json.Members;
import com.naturalmotion.webservice.service.json.ScoreCrew;
import com.naturalmotion.webservice.service.json.ScoreMember;
import com.naturalmotion.webservice.service.json.Wildcards;
import com.naturalmotion.webservice.service.json.event.Player;
import com.naturalmotion.webservice.service.json.event.ScoreEvent;
import com.naturalmotion.webservice.service.json.profile.Event;
import com.naturalmotion.webservice.service.json.profile.Extra;
import com.naturalmotion.webservice.service.json.profile.NonSecureBlob;
import com.naturalmotion.webservice.service.json.profile.Profile;
import com.naturalmotion.webservice.service.json.profile.SecureBlob;
import com.naturalmotion.webservice.service.json.profile.Transaction;
import com.naturalmotion.webservice.service.json.profile.ZipProfile;
import com.naturalmotion.webservice.service.json.tchat.Conversation;
import com.naturalmotion.webservice.service.json.tchat.Message;
import com.naturalmotion.webservice.service.json.tchat.params.ChatBodyParams;
import com.naturalmotion.webservice.service.json.tchat.params.Filters;
import com.naturalmotion.webservice.service.json.tchat.params.Range;

import csr.Checksum;

public class CrewResources {

	private Crew crewService = new CrewService();

	private CrewChat crewChatService = new CrewChatService();

	private HtmlConverter htmlConverter = new HtmlConverter();

	public List<Member> getMembers(Authorization auth) {
		List<Member> result = new ArrayList<Member>();
		Members members = crewService.members(auth.getAuthToken(), auth.getUserAgent(), auth.getPidValidation(),
		        auth.getPlayerId());
		List<ScoreMember> list = members.getScores();
		list.sort(new MemberComparator());

		for (int i = 0; i < list.size(); i++) {
			ScoreMember member = list.get(i);
			String name = member.getName();
			Member actual = new Member();
			actual.setName(htmlConverter.convert(name));
			actual.setId(member.getPlayer_uid());
			actual.setRank(i + 1);
			actual.setRole(member.getRole());
			actual.setLevel(member.getLevel());
			actual.setToken(member.getToken_donated());
			actual.setPoints(member.getCc_contrib());
			result.add(actual);
		}
		return result;
	}

	public com.naturalmotion.webservice.api.Crew getCrew(Authorization auth) {
		CrewBodyParam param = new CrewBodyParam();
		param.setApp_ver("3.0.2");
		param.setBefore(0);
		param.setAfter(0);
		param.setTop(0);
		param.setOffset(0);
		Leaderbord crews = crewService.leaders(auth.getAuthToken(), auth.getUserAgent(), auth.getPidValidation(),
		        auth.getPlayerId(), "application/json", param);
		List<ScoreCrew> list = crews.getScores();

		ScoreCrew crew = list.get(0);
		String name = crew.getName();
		com.naturalmotion.webservice.api.Crew actual = new com.naturalmotion.webservice.api.Crew();
		actual.setName(htmlConverter.convert(name));
		actual.setRank(crew.getRank());
		actual.setPoints(Integer.parseInt(crew.getScore()));
		actual.setId(crew.getCrew_id());
		return actual;
	}

	public List<com.naturalmotion.webservice.api.Crew> getLeaderCrews(Authorization auth, String crew2) {
		List<com.naturalmotion.webservice.api.Crew> result = new ArrayList<com.naturalmotion.webservice.api.Crew>();
		CrewBodyParam param = new CrewBodyParam();
		param.setApp_ver("3.0.2");
		param.setBefore(500);
		param.setAfter(500);
		param.setTop(500);
		param.setOffset(0);
		Leaderbord crews = crewService.leaders(auth.getAuthToken(), auth.getUserAgent(), auth.getPidValidation(),
		        auth.getPlayerId(), "application/json", param);
		List<ScoreCrew> list = crews.getScores();

		for (int i = 0; i < list.size(); i++) {
			ScoreCrew crew = list.get(i);
			String name = crew.getName();
			com.naturalmotion.webservice.api.Crew actual = new com.naturalmotion.webservice.api.Crew();
			actual.setName(htmlConverter.convert(name));
			actual.setRank(crew.getRank());
			actual.setPoints(Integer.parseInt(crew.getScore()));
			actual.setId(crew.getCrew_id());
			result.add(actual);
		}
		return result;
	}

	public List<Card> getWildcards(Authorization auth) {
		Wildcards wildcards = crewService.wildcards(auth.getAuthToken(), auth.getUserAgent(), auth.getPidValidation(),
		        auth.getPlayerId(), "application/json");
		return wildcards.getCards();
	}

	public JsonObject getFullProfile(Authorization auth) throws IOException {
		ZipProfile profile = crewService.profile(auth.getAuthToken(), auth.getUserAgent(), auth.getPidValidation(),
		        auth.getPlayerId());

		byte[] decodedBytes = Base64.getDecoder().decode(profile.getNonsecureBlob().getBlob());

		GZIPInputStream zipStream = new GZIPInputStream(new ByteArrayInputStream(decodedBytes));
		BufferedReader reader = new BufferedReader(new InputStreamReader(zipStream, "UTF-8"));

		// skip hmac
		reader.readLine();

		String line = null;
		StringBuilder nsb = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			nsb.append(line);
		}

		JsonObject jobj = convertStringToJson(nsb.toString());

		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("nsb", jobj);
		String scb = new ObjectMapper().writeValueAsString(profile.getSecureBlob());
		builder.add("scb", convertStringToJson(scb));

		return builder.build();
	}

	private JsonObject convertStringToJson(String nsb) {
		JsonObject jobj = null;
		try (StringReader sReader = new StringReader(nsb)) {
			JsonReader createReader = Json.createReader(sReader);
			jobj = createReader.readObject();
		}
		return jobj;
	}

	public void updateProfile(Authorization auth, File nsbFile, File scb) throws IOException {
		ZipProfile profile = crewService.profile(auth.getAuthToken(), auth.getUserAgent(), auth.getPidValidation(),
		        auth.getPlayerId());

		String content = getContent(nsbFile);
		String hmac = new Checksum().computeHmac(content);

		ByteArrayOutputStream obj = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(obj);
		gzip.write(new StringBuilder(hmac).append("\n").append(content).toString().getBytes());
		gzip.close();

		// Encode Base 64
		String encode = Base64.getEncoder().encodeToString(obj.toByteArray());

		// Finally update profile
		NonSecureBlob nonsecureBlob = profile.getNonsecureBlob();
		nonsecureBlob.setBlob(encode);

		// Add CRC32
		String hash = getHash(nonsecureBlob);

		ProfileBodyParam param = new ProfileBodyParam();
		param.setNonSecureHash(hash);
		param.setNonSecureHashAlt(profile.getNonSecureHash()); // Ancien Hash
		param.setNonsecureBlob(nonsecureBlob);

		String scbContent = getContent(scb);
		SecureBlob secureBlob = new ObjectMapper().readValue(scbContent, SecureBlob.class);

		param.setSecureBlob(secureBlob);
		param.setSecureHash(getHash(secureBlob));
		param.setSecureHashAlt(profile.getSecureHash()); // Ancien Hash

		List<Transaction> transactions = new ArrayList<>();
		Transaction transaction = new Transaction();
		transaction.setAction("TrackedParameterChanged");
		transaction.setIncrease(1);
		transaction.setTimestamp(System.currentTimeMillis());
		transaction.setReason("Session");
		Extra extra = new Extra();
		extra.setUpdateBs(true);
		transaction.setExtra(extra);
		transactions.add(transaction);
		param.setTransactions(transactions);

		crewService.updateTransactions(auth.getAuthToken(), auth.getUserAgent(), auth.getPidValidation(),
		        auth.getPlayerId(), "application/json", "application/json", param);
	}

	private String getContent(File nsbFile) throws FileNotFoundException {
		String content = null;
		FileInputStream inputStream = new FileInputStream(nsbFile);
		try (JsonReader jsReader = Json.createReader(inputStream)) {
			JsonObject readObject = jsReader.readObject();
			content = readObject.toString();
		}
		return content;
	}

	private String getHash(Object object) throws JsonProcessingException {
		CRC32 crc32 = new CRC32();
		crc32.update(new ObjectMapper().writeValueAsBytes(object));
		return String.valueOf(crc32.getValue());
	}

	public com.naturalmotion.webservice.api.Profile getProfile(Authorization auth) throws IOException {
		ZipProfile profile = crewService.profile(auth.getAuthToken(), auth.getUserAgent(), auth.getPidValidation(),
		        auth.getPlayerId());

		byte[] decodedBytes = Base64.getDecoder().decode(profile.getNonsecureBlob().getBlob());

		GZIPInputStream zipStream = new GZIPInputStream(new ByteArrayInputStream(decodedBytes));
		BufferedReader reader = new BufferedReader(new InputStreamReader(zipStream, "UTF-8"));

		// skip hmac
		reader.readLine();

		String line = null;
		StringBuilder nsb = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			nsb.append(line);
		}

		com.naturalmotion.webservice.api.Profile nsbUnzip = new com.naturalmotion.webservice.api.Profile();
		ObjectMapper mapper = new ObjectMapper();

		Profile readValue = mapper.readValue(nsb.toString(), Profile.class);
		for (Event event : readValue.getEvleadrecs()) {
			nsbUnzip.addEvent(event.getLuid());
		}
		return nsbUnzip;
	}

	public List<Player> getEventCrewScore(Authorization auth, String event) {
		CrewBodyParam param = new CrewBodyParam();
		param.setApp_ver("3.0.2");
		param.setBefore(30);
		param.setAfter(30);
		param.setTop(10);
		param.setOffset(0);
		ScoreEvent score = crewService.eventLeaderboard(auth.getAuthToken(), auth.getUserAgent(),
		        auth.getPidValidation(), auth.getPlayerId(), event, "application/json", param);
		List<Player> players = score.getPlayers();
		players.stream().forEach(x -> x.setName(htmlConverter.convert(x.getName())));
		return players;
	}

	public List<List<Message>> getConversations(Authorization auth, String crewId) {
		List<List<Message>> result = new ArrayList<List<Message>>();

		addConvToResult(getConversation(auth, crewId, "crew_chat_id_"), result);
		addConvToResult(getConversation(auth, crewId, "crew_events_id_"), result);

		return result;
	}

	private Map<String, Conversation> getConversation(Authorization auth, String crewId, String conversationId) {
		ChatBodyParams bodyParams = createChatParam(conversationId, crewId);
		return crewChatService.conversations(auth.getAuthToken(), auth.getUserAgent(), "application/json",
		        auth.getPlayerId(), bodyParams);
	}

	private void addConvToResult(Map<String, Conversation> conversations, List<List<Message>> result) {
		Set<String> keySet = conversations.keySet();
		for (String key : keySet) {
			Conversation actual = conversations.get(key);
			Map<String, Message> mapMessages = actual.getMessages();
			List<Message> messages = new ArrayList<Message>();
			mapMessages.forEach((x, y) -> {
				if (StringUtils.isNotBlank(y.getZid())) {
					y.setId(x);
					messages.add(y);
				}
			});

			Collections.sort(messages, (x, y) -> y.getCreationTime().compareTo(x.getCreationTime()));
			result.add(messages);
		}
	}

	private ChatBodyParams createChatParam(String chat, String crewId) {
		ChatBodyParams bodyParams = new ChatBodyParams();
		List<String> ids = new ArrayList<>();
		ids.add(chat + crewId);
		bodyParams.setIds(ids);
		Filters filters = new Filters();
		List<String> attrs = new ArrayList<String>();
		attrs.add("messages");
		filters.setAttrs(attrs);
		Range range = new Range();
		range.setLimit("100");
		filters.setRange(range);
		bodyParams.setFilters(filters);
		return bodyParams;
	}
}
