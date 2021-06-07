package com.naturalmotion.webservice.service;

import java.util.Arrays;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.naturalmotion.webservice.service.json.CrewBodyParam;
import com.naturalmotion.webservice.service.json.GenericResponse;
import com.naturalmotion.webservice.service.json.Leaderbord;
import com.naturalmotion.webservice.service.json.Login;
import com.naturalmotion.webservice.service.json.Members;
import com.naturalmotion.webservice.service.json.Wildcards;
import com.naturalmotion.webservice.service.json.event.ScoreEvent;
import com.naturalmotion.webservice.service.json.profile.ZipProfile;

public class CrewService implements Crew {

	private static final String CSR_HOST = "https://prod-web.csr2.zynga.com/";

	private Crew crew;

	public CrewService() {
		crew = JAXRSClientFactory.create(CSR_HOST, Crew.class, Arrays.asList(new JacksonJsonProvider()));
	}

	@Override
	public Members members(String auth, String userAgent, String pidToken, String playerId) {
		return crew.members(auth, userAgent, pidToken, playerId);
	}

	@Override
	public Leaderbord leaders(String auth, String userAgent, String pidToken, String playerId, String contentType,
			CrewBodyParam param) {
		return crew.leaders(auth, userAgent, pidToken, playerId, contentType, param);
	}

	@Override
	public Wildcards wildcards(String auth, String userAgent, String pidToken, String playerId, String contentType) {
		return crew.wildcards(auth, userAgent, pidToken, playerId, contentType);
	}

	@Override
	public ZipProfile profile(String auth, String userAgent, String pidToken, String playerId) {
		return crew.profile(auth, userAgent, pidToken, playerId);
	}

	@Override
	public ScoreEvent eventLeaderboard(String auth, String userAgent, String pidToken, String playerId, String event,
			String contentType, CrewBodyParam param) {
		return crew.eventLeaderboard(auth, userAgent, pidToken, playerId, event, contentType, param);
	}

	@Override
	public Login login(String auth, String userAgent, String pidToken, String playerId) {
		return crew.login(auth, userAgent, pidToken, playerId);
	}

	@Override
	public GenericResponse update(String auth, String userAgent, String pidToken, String playerId, String contentType,
			ProfileBodyParam param) {
		return crew.update(auth, userAgent, pidToken, playerId, contentType, param);
	}

	@Override
	public GenericResponse updateTransactions(String auth, String userAgent, String pidToken, String playerId,
			String accept, String contentType, ProfileBodyParam param) {
		return crew.updateTransactions(auth, userAgent, pidToken, playerId, accept, contentType, param);
	}
}
