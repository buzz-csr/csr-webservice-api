package com.naturalmotion.webservice.service.auth;

import com.naturalmotion.webservice.configuration.ConfigSession;
import com.naturalmotion.webservice.configuration.Configuration;
import com.naturalmotion.webservice.configuration.json.Auth;

public class AuthorizationFactory {

	private Configuration configuration = new Configuration();

	public Authorization get(String team) {
		ConfigSession configSession = new ConfigSession(configuration);
		Auth auth = configSession.get(team);
		Authorization authorization = new Authorization();
		authorization.setAuthToken(auth.getAuth());
		authorization.setPidValidation(auth.getPidValidToken());
		authorization.setPlayerId(auth.getPlayerId());
		authorization.setUserAgent(configuration.getString("user-agent"));
		return authorization;
	}
}
