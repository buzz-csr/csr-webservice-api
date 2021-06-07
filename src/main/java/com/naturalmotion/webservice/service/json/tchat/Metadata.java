package com.naturalmotion.webservice.service.json.tchat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.naturalmotion.webservice.service.MetaDeserializer;

@JsonDeserialize(using = MetaDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {

	private String playerName;

	private String eventID;

	private Card card;

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}
