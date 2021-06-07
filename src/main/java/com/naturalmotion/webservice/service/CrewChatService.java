package com.naturalmotion.webservice.service;

import java.util.Arrays;
import java.util.Map;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.naturalmotion.webservice.service.json.tchat.Conversation;
import com.naturalmotion.webservice.service.json.tchat.params.ChatBodyParams;

public class CrewChatService implements CrewChat {

	private static final String CSR_CHAT_HOST = "https://api.zynga.com/";

	private CrewChat crewChat;

	public CrewChatService() {
		crewChat = JAXRSClientFactory.create(CSR_CHAT_HOST, CrewChat.class, Arrays.asList(new JacksonJsonProvider()));
	}

	@Override
	public Map<String, Conversation> conversations(String auth, String userAgent, String contentType, String accept,
			ChatBodyParams bodyParams) {
		return crewChat.conversations(auth, userAgent, contentType, accept, bodyParams);
	}
}
