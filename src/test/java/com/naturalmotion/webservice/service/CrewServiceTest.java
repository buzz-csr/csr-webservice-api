package com.naturalmotion.webservice.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naturalmotion.webservice.service.json.CrewBodyParam;
import com.naturalmotion.webservice.service.json.GenericResponse;
import com.naturalmotion.webservice.service.json.Leaderbord;
import com.naturalmotion.webservice.service.json.Login;
import com.naturalmotion.webservice.service.json.Members;
import com.naturalmotion.webservice.service.json.Wildcards;
import com.naturalmotion.webservice.service.json.profile.Extra;
import com.naturalmotion.webservice.service.json.profile.ExtraBuilder;
import com.naturalmotion.webservice.service.json.profile.NonSecureBlob;
import com.naturalmotion.webservice.service.json.profile.SecureBlob;
import com.naturalmotion.webservice.service.json.profile.Transaction;
import com.naturalmotion.webservice.service.json.profile.TransactionBuilder;
import com.naturalmotion.webservice.service.json.profile.ZipProfile;

import csr.Checksum;

public class CrewServiceTest {

	private static final String TYPE = "application/json";
	private static final String PLAYER = "73336037157";
	private static final String PID_VALIDATION = "3eee1afc3d8087498a0af3ae3509a720195d4f38";
	private static final String AGENT = "app=customstreetracer2; ver=3.3.0; dev=iPad7,3; os=iOS; osver=14.2; res=1920x1440";
	private static final String AUTH = "token YzVlNGI3ZmYyNWNjNjNiODcwM2I3MjMwODZhMmMwNjMyODU5ZmIxYzZlNmM0MjFlODZkNWUxYWVlNjMxNzQ4MXxubXw4MzQwODk3NzM2OXw1MDAyOTQ0fDE2MzE4MDUyNzc=";
	private CrewService service = new CrewService();

	@Test
	public void testMembers() throws Exception {
		Members members = service.members(AUTH, AGENT, PID_VALIDATION, PLAYER);
		Assertions.assertThat(members.getScores()).isNotNull();
	}

	@Test
	public void testLeaders() throws Exception {
		CrewBodyParam param = new CrewBodyParam();
		param.setApp_ver("3.3.0");
		param.setBefore(100);
		param.setAfter(500);
		param.setOffset(0);
		Leaderbord leaders = service.leaders(AUTH, AGENT, PID_VALIDATION, PLAYER, TYPE, param);
		Assertions.assertThat(leaders.getScores()).isNotNull();
	}

	@Test
	public void testWildcards() throws Exception {
		Wildcards wildcards = service.wildcards(AUTH, AGENT, PID_VALIDATION, PLAYER, TYPE);
		Assertions.assertThat(wildcards.getCards()).isNotNull();
	}

	@Test
	public void testProfile() throws Exception {
		ZipProfile profile = service.profile(AUTH, AGENT, PID_VALIDATION, PLAYER);
		Assertions.assertThat(profile).isNotNull();
		Assertions.assertThat(profile.getNonsecureBlob()).isNotNull();
		Assertions.assertThat(profile.getNonsecureBlob().getBlob()).isNotNull();
	}

	@Test
	@Ignore
	public void testProfileUpdateTransactionsForSd() throws Exception {
		ZipProfile profile = service.profile(AUTH, AGENT, PID_VALIDATION, PLAYER);

		ProfileBodyParam param = updateNsb(profile, -10000, true);

		param.setAppVersion("3.3.0");

		SecureBlob secureBlob = updateScb(profile, -10000);

		param.setSecureBlob(secureBlob);
		param.setSecureHash(getHash(secureBlob));
		param.setSecureHashAlt(profile.getSecureHash());

		List<Transaction> transactions = new ArrayList<>();
		long time = System.currentTimeMillis();

		transactions.add(new TransactionBuilder().action("TrackedParameterChanged").increase(1)
				.reason("ShowdownRaceComplete").timestamp(time).extra(new ExtraBuilder().updateBs(true)).build());
		transactions.add(new TransactionBuilder().action("TrackedParameterChanged").increase(1)
				.reason("ShowdownRaceWon").timestamp(time).extra(new ExtraBuilder().updateBs(true)).build());
		transactions.add(new TransactionBuilder().action("CashEarned").increase(5000).boost(250)
				.reason("RaceRewardWithBonus").timestamp(time).build());
		transactions.add(new TransactionBuilder().action("CashEarned").increase(210).reason("RaceReward")
				.timestamp(time).build());
		transactions.add(new TransactionBuilder().action("RacesInCrewEarned").increase(1).reason("RacedWhileInACrew")
				.timestamp(time).build());
		transactions.add(new TransactionBuilder().action("FreshRPEarned").increase(75).timestamp(time)
				.crewUid("18516329").build());
		transactions.add(new TransactionBuilder().action("RPEarned").increase(741).boost(223).reason("ShowdownRaceWin")
				.timestamp(time).extra(new ExtraBuilder().smpOpponentId("81756608178")).build());
		transactions.add(new TransactionBuilder().action("EventAction").timestamp(time).actionResult(8293699)
				.eventid("300046713").seriesId("SMP_SHOWDOWN_140_W2")
				.extra(new ExtraBuilder().garageIndex(391).carUid(1382)
						.userInputs(0, 236, 238, 460, 708, 932, 1220, 1712, 7233.951171875, 8, -0.117)
						.ladderEventId(300046713).opponentId("81756608178").raceId("1626728482011323")
						.opponentActionResult(11481886)
						.raceSignature("cb15dd7d884139c3db1981e7630fbd268b52dcc6ba72ba89079432d4b0bc2c59")
						.raceTimestamp("1626725227").racestate(false).winnerCarId("Ferrari_RomaRewardRecycled_2020")
						.loserCarId("Ford_GT_2005").leaguesEnabled(true).opponentLeaguesEnabled(true)
						.clientPhysicsVersion(81))
				.build());

		param.setTransactions(transactions);

		GenericResponse res = service.updateTransactions(AUTH, AGENT, PID_VALIDATION, PLAYER, TYPE, TYPE, param);
		Assertions.assertThat(res.getErrorCode()).isEqualTo(0);
	}

	@Test
	@Ignore
	public void testProfileUpdateTransactionsSimple() throws Exception {
		ZipProfile profile = service.profile(AUTH, AGENT, PID_VALIDATION, PLAYER);

		ProfileBodyParam param = updateNsb(profile, -10000, false);

		param.setAppVersion("3.3.0");

		SecureBlob secureBlob = updateScb(profile, -10000);

		param.setSecureBlob(secureBlob);
		param.setSecureHash(getHash(secureBlob));
		param.setSecureHashAlt(profile.getSecureHash());

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

		GenericResponse res = service.updateTransactions(AUTH, AGENT, PID_VALIDATION, PLAYER, TYPE, TYPE, param);
		Assertions.assertThat(res.getErrorCode()).isEqualTo(0);
	}

	private SecureBlob updateScb(ZipProfile profile, int goldDelta) {
		SecureBlob secureBlob = profile.getSecureBlob();
//		secureBlob.setGoldSpent(secureBlob.getGoldSpent() - goldDelta);
		return secureBlob;
	}

	@Test
	@Ignore
	public void testProfileUpdate() throws Exception {
		ZipProfile profile = service.profile(AUTH, AGENT, PID_VALIDATION, PLAYER);

		ProfileBodyParam param = updateNsb(profile, 10000, false);
		param.setAppVersion("3.3.0");

		GenericResponse res = service.update(AUTH, AGENT, PID_VALIDATION, PLAYER, TYPE, param);
		Assertions.assertThat(res.getErrorCode()).isEqualTo(0);
	}

	private ProfileBodyParam updateNsb(ZipProfile profile, int goldDelta, boolean updateSd)
			throws IOException, UnsupportedEncodingException, JsonProcessingException {
		// Decode Base 64
		byte[] decodedBytes = Base64.getDecoder().decode(profile.getNonsecureBlob().getBlob());

		// Unzip
		GZIPInputStream zipStream = new GZIPInputStream(new ByteArrayInputStream(decodedBytes));
		BufferedReader reader = new BufferedReader(new InputStreamReader(zipStream, "UTF-8"));

		// skip hmac
		reader.readLine();

		String line = null;
		StringBuilder nsb = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			nsb.append(line);
		}

		// Create nsb Json object
		StringReader sReader = new StringReader(nsb.toString());
		JsonReader createReader = Json.createReader(sReader);
		JsonObject jobj = createReader.readObject();
		JsonObjectBuilder builder = Json.createObjectBuilder(jobj);

		if (updateSd) {

			JsonArray sdList = jobj.getJsonArray("shwdnrecs");
			JsonArrayBuilder newSdList = Json.createArrayBuilder();

			for (int i = 0; i < sdList.size(); i++) {
				JsonObject sd = sdList.getJsonObject(i);
				String sdName = sd.getString("suid");
				if (sdName.equals("SMP_SHOWDOWN_140_W2")) {
					JsonObjectBuilder newSd = Json.createObjectBuilder(sd);
					newSd.add("htrc", sd.getInt("ctrc") + 30);
					newSd.add("ctrc", sd.getInt("ctrc") + 30);
					newSd.add("ptrc", sd.getInt("ctrc"));
					newSd.add("nrw", sd.getInt("nrw") + 1);
					newSd.add("ppbt", sd.getInt("nrw") + sd.getInt("nrl") + 1);
//					newSd.add("htrc", 1380);
//					newSd.add("ctrc", 1380);
//					newSd.add("ptrc", 1363);
//					newSd.add("mpbt", 1400);
//					newSd.add("nrw", 10);
//					newSd.add("ppbt", 10);
//					newSd.add("sbotr", 5);
//					newSd.add("tbotr", 5);
//					newSd.add("lsr", 0);
					newSdList.add(newSd);
				} else {
					newSdList.add(sd);
				}
			}

			// Update data
			builder.add("shwdnrecs", newSdList);

		}
		builder.add("showdnsrc", jobj.getInt("showdnsrc") + 1);

//		int newGoldSpent = jobj.getInt("gosp") - goldDelta;
//		builder.add("gosp", newGoldSpent);

		// Comput hmac
		String newContent = builder.build().toString();
		String hmac = new Checksum().computeHmac(newContent);

		ByteArrayOutputStream obj = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(obj);
		gzip.write(new StringBuilder(hmac).append("\n").append(newContent).toString().getBytes());
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
		return param;
	}

	private String getHash(Object object) throws JsonProcessingException {
		CRC32 crc32 = new CRC32();
		crc32.update(new ObjectMapper().writeValueAsBytes(object));
		return String.valueOf(crc32.getValue());
	}

	@Test
	public void testLogin() throws Exception {
		Login login = service.login(AUTH, AGENT, PID_VALIDATION, PLAYER);
		Assertions.assertThat(login.getSecureHash()).isNotEmpty();
		Assertions.assertThat(login.getNonSecureHash()).isNotEmpty();
		Assertions.assertThat(login.getAccountHash()).isNotEmpty();
	}

}
