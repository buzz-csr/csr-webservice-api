package com.naturalmotion.webservice.api;

import java.util.ArrayList;
import java.util.List;

public class Profile {

	private List<String> events = new ArrayList<String>();

	private int goldEarned;

	private int goldSpent;

	public void addEvent(String event) {
		events.add(event);
	}

	public List<String> getEvents() {
		return events;
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
