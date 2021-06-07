package com.naturalmotion.webservice.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naturalmotion.webservice.service.json.tchat.Data;
import com.naturalmotion.webservice.service.json.tchat.Metadata;

public class MetaDeserializer extends JsonDeserializer<Metadata> {

	@Override
	public Metadata deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		Metadata metadata = new Metadata();

		while (p.nextToken() != JsonToken.END_OBJECT) {
			String name = p.getCurrentName();
			if ("playerName".equals(name)) {
				metadata.setPlayerName(p.getValueAsString());
			} else if ("eventID".equals(name)) {
				metadata.setEventID(p.getValueAsString());
			} else if ("data".equals(name)) {
				p.nextToken();
				if (metadata.getEventID().equals("WCARD_STATUS")) {
					Data readValue = new ObjectMapper().readValue(p, Data.class);
					metadata.setCard(readValue.getCards().get(0));
				}
			}

		}

		return metadata;
	}

}
