package com.naturalmotion.webservice.service.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScoreMember {

	private String player_uid;

	private String name;

	private int token_donated;

	private int level;

	private String role;

	private int cc_contrib;

	public String getPlayer_uid() {
		return player_uid;
	}

	public void setPlayer_uid(String player_uid) {
		this.player_uid = player_uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCc_contrib() {
		return cc_contrib;
	}

	public void setCc_contrib(int cc_contrib) {
		this.cc_contrib = cc_contrib;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getToken_donated() {
		return token_donated;
	}

	public void setToken_donated(int token_donated) {
		this.token_donated = token_donated;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
