package com.naturalmotion.webservice.configuration.json;

public class Auth {

	private String auth;

	private String playerId;

	private String pidValidToken;

	private String expirationDate;

	private String creationDate;

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getPidValidToken() {
		return pidValidToken;
	}

	public void setPidValidToken(String pidValidToken) {
		this.pidValidToken = pidValidToken;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

}
