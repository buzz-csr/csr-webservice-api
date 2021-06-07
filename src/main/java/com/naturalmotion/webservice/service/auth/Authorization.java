package com.naturalmotion.webservice.service.auth;

public class Authorization {

	private String authToken;

	private String playerId;

	private String pidValidation;

	private String userAgent;

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPidValidation() {
		return pidValidation;
	}

	public void setPidValidation(String pidValidation) {
		this.pidValidation = pidValidation;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getUserAgent() {
		return userAgent;
	}

}
