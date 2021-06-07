package com.naturalmotion.webservice.service;

import java.util.Map;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import com.naturalmotion.webservice.service.json.tchat.Conversation;
import com.naturalmotion.webservice.service.json.tchat.params.ChatBodyParams;

@Path("/")
@Component
public interface CrewChat {

	@POST
	@Path("/conversation/get")
	@Produces
	Map<String, Conversation> conversations(@HeaderParam("Authorization") String auth,
			@HeaderParam("User-Agent") String userAgent, @HeaderParam("Content-Type") String contentType,
			@HeaderParam("PlayerID") String playerId, ChatBodyParams params);
}
