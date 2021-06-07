package com.naturalmotion.webservice.service.auth;

import com.naturalmotion.webservice.configuration.Configuration;

public class AuthorizationFactory {

	private Configuration configuration = new Configuration();

	public Authorization get(String team) {
		Authorization authorization = new Authorization();
		authorization.setAuthToken(configuration.getString(team + ".authorization"));
		authorization.setPidValidation(configuration.getString(team + ".PIDValidation"));
		authorization.setPlayerId(configuration.getString(team + ".player-id"));
		authorization.setUserAgent(configuration.getString("user-agent"));
		return authorization;
	}
}
