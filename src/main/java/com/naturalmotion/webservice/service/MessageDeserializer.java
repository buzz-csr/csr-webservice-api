package com.naturalmotion.webservice.service;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naturalmotion.webservice.service.json.tchat.Message;
import com.naturalmotion.webservice.service.json.tchat.Metadata;

public class MessageDeserializer extends JsonDeserializer<Message> {

	@Override
	public Message deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		Message message = new Message();

		while (p.nextToken() != JsonToken.END_OBJECT) {
			String name = p.getCurrentName();
			p.nextToken();
			if ("zid".equals(name)) {
				message.setZid(p.getValueAsString());
			} else if ("text".equals(name)) {
				message.setText(p.getValueAsString());
			} else if ("creationTime".equals(name)) {
				message.setCreationTime(new Date(p.getLongValue() * 1000));
			} else if ("meta".equals(name)) {
				Metadata meta = new ObjectMapper().readValue(p, Metadata.class);
				message.setMeta(meta);
			}
		}

		return message;
	}

}
