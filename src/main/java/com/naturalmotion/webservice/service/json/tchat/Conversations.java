package com.naturalmotion.webservice.service.json.tchat;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Conversations {

	private Map<String, Conversation> conversations;

	public Map<String, Conversation> getConversations() {
		return conversations;
	}

	public void setConversations(Map<String, Conversation> conversations) {
		this.conversations = conversations;
	}

}
