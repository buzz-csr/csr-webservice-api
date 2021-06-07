package com.naturalmotion.webservice.service.json.profile;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile {

	private List<Event> evleadrecs;

	@JsonProperty("goea")
	private int goldEarned;

	@JsonProperty("gosp")
	private int goldSpent;

	public List<Event> getEvleadrecs() {
		return evleadrecs;
	}

	public void setEvleadrecs(List<Event> evleadrecs) {
		this.evleadrecs = evleadrecs;
	}

	public int getGoldEarned() {
		return goldEarned;
	}

	public void setGoldEarned(int goldEarned) {
		this.goldEarned = goldEarned;
	}

	public int getGoldSpent() {
		return goldSpent;
	}

	public void setGoldSpent(int goldSpent) {
		this.goldSpent = goldSpent;
	}

}
