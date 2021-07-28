package com.naturalmotion.webservice.service.auth;

import com.naturalmotion.webservice.configuration.ConfigSession;
import com.naturalmotion.webservice.configuration.Configuration;

public class AuthorizationFactory {

	private Configuration configuration = new Configuration();

	public Authorization get(String team) {
		ConfigSession configSession = new ConfigSession(configuration);
		Authorization authorization = new Authorization();
		authorization.setAuthToken(configSession.getString(team + ".authorization"));
		authorization.setPidValidation(configSession.getString(team + ".PIDValidation"));
		authorization.setPlayerId(configSession.getString(team + ".player-id"));
		authorization.setUserAgent(configuration.getString("user-agent"));
		return authorization;
	}
}
