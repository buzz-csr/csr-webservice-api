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
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

import org.assertj.core.api.Assertions;
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
import com.naturalmotion.webservice.service.json.profile.NonSecureBlob;
import com.naturalmotion.webservice.service.json.profile.SecureBlob;
import com.naturalmotion.webservice.service.json.profile.Transaction;
import com.naturalmotion.webservice.service.json.profile.ZipProfile;

import csr.Checksum;

public class CrewServiceTest {

	private static final String TYPE = "application/json";
	private static final String PLAYER = "73336037157";
	private static final String PID_VALIDATION = "07c729cbe9d6bcb42d23ab227731b67c80e61145";
	private static final String AGENT = "app=customstreetracer2; ver=3.0.2; dev=iPad7,3; os=iOS; osver=14.2; res=1920x1440";
	private static final String AUTH = "token MWNjN2M0MDBiMTI4NjExZTA5NmUxNjNiYTNlODBmZmQ0MDY0MzJmMGY3NjM0YWUyZThkZTNiNTc0YTBlODg1OHxubXw4MzAzMDY4NzY5Nnw1MDAyOTQ0fDE2MjUyMjYwOTI=";
	private CrewService service = new CrewService();

	@Test
	public void testMembers() throws Exception {
		Members members = service.members(AUTH, AGENT, PID_VALIDATION, PLAYER);
		Assertions.assertThat(members.getScores()).isNotNull();
	}

	@Test
	public void testLeaders() throws Exception {
		CrewBodyParam param = new CrewBodyParam();
		param.setApp_ver("3.0.2");
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
	public void testProfileUpdateOriginal() throws Exception {
		ZipProfile profile = service.profile(AUTH, AGENT, PID_VALIDATION, PLAYER);

		ProfileBodyParam param = new ProfileBodyParam();
		param.setNonSecureHash(profile.getNonSecureHash());
		param.setNonSecureHashAlt(profile.getNonSecureHash());
		param.setNonsecureBlob(profile.getNonsecureBlob());
		GenericResponse res = service.update(AUTH, AGENT, PID_VALIDATION, PLAYER, TYPE, param);
		Assertions.assertThat(res.getErrorCode()).isEqualTo(0);
	}

	@Test
	public void testProfileUpdateTransactions() throws Exception {
		ZipProfile profile = service.profile(AUTH, AGENT, PID_VALIDATION, PLAYER);

		ProfileBodyParam param = updateNsb(profile, -10000);

		param.setAppVersion("3.1.0");

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

		System.out.println(new ObjectMapper().writeValueAsString(param.getSecureBlob()));

		GenericResponse res = service.updateTransactions(AUTH, AGENT, PID_VALIDATION, PLAYER, TYPE, TYPE, param);
		Assertions.assertThat(res.getErrorCode()).isEqualTo(0);
	}

	private SecureBlob updateScb(ZipProfile profile, int goldDelta) {
		SecureBlob secureBlob = profile.getSecureBlob();
		secureBlob.setGoldSpent(secureBlob.getGoldSpent() - goldDelta);
		return secureBlob;
	}

	@Test
	public void testProfileUpdate() throws Exception {
		ZipProfile profile = service.profile(AUTH, AGENT, PID_VALIDATION, PLAYER);

		ProfileBodyParam param = updateNsb(profile, 10000);
		param.setAppVersion("3.1.0");

		GenericResponse res = service.update(AUTH, AGENT, PID_VALIDATION, PLAYER, TYPE, param);
		Assertions.assertThat(res.getErrorCode()).isEqualTo(0);
	}

	private ProfileBodyParam updateNsb(ZipProfile profile, int goldDelta)
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

		// Update data
		JsonObjectBuilder builder = Json.createObjectBuilder(jobj);
		int newGoldSpent = jobj.getInt("gosp") - goldDelta;
		builder.add("gosp", newGoldSpent);

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
