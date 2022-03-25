package com.naturalmotion.webservice.service;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import com.naturalmotion.webservice.service.json.CrewBodyParam;
import com.naturalmotion.webservice.service.json.GenericResponse;
import com.naturalmotion.webservice.service.json.Leaderbord;
import com.naturalmotion.webservice.service.json.Login;
import com.naturalmotion.webservice.service.json.Members;
import com.naturalmotion.webservice.service.json.Wildcards;
import com.naturalmotion.webservice.service.json.event.ScoreEvent;
import com.naturalmotion.webservice.service.json.profile.ZipProfile;

@Path("/")
@Component
public interface Crew {

	@POST
	@Path("/users/login")
	@Produces
	Login login(@HeaderParam("Authorization") String auth, @HeaderParam("User-Agent") String userAgent,
	        @HeaderParam("PIDValidationToken") String pidToken, @HeaderParam("PlayerID") String playerId);

	@POST
	@Path("/crews/viewMembers")
	@Produces
	Members members(@HeaderParam("Authorization") String auth, @HeaderParam("User-Agent") String userAgent,
	        @HeaderParam("PIDValidationToken") String pidToken, @HeaderParam("PlayerID") String playerId);

	@POST
	@Path("/leaderboard/crew-champs-v2/viewcrew")
	@Produces
	Leaderbord leaders(@HeaderParam("Authorization") String auth, @HeaderParam("User-Agent") String userAgent,
	        @HeaderParam("PIDValidationToken") String pidToken, @HeaderParam("PlayerID") String playerId,
	        @HeaderParam("Content-Type") String contentType, CrewBodyParam param);

	@POST
	@Path("/wildcards/status")
	@Produces
	Wildcards wildcards(@HeaderParam("Authorization") String auth, @HeaderParam("User-Agent") String userAgent,
	        @HeaderParam("PIDValidationToken") String pidToken, @HeaderParam("PlayerID") String playerId,
	        @HeaderParam("Content-Type") String contentType);

	@POST
	@Path("/users/fetchProfile")
	@Produces
	ZipProfile profile(@HeaderParam("Authorization") String auth, @HeaderParam("User-Agent") String userAgent,
	        @HeaderParam("PIDValidationToken") String pidToken, @HeaderParam("PlayerID") String playerId);

	@POST
	@Path("/users/updateProfileNonsecure")
	@Produces
	GenericResponse update(@HeaderParam("Authorization") String auth, @HeaderParam("User-Agent") String userAgent,
	        @HeaderParam("PIDValidationToken") String pidToken, @HeaderParam("PlayerID") String playerId,
	        @HeaderParam("Content-Type") String contentType, ProfileBodyParam param);

	@POST
	@Path("/users/updateProfileTransactions")
	@Produces
	GenericResponse updateTransactions(@HeaderParam("Authorization") String auth,
	        @HeaderParam("User-Agent") String userAgent, @HeaderParam("PIDValidationToken") String pidToken,
	        @HeaderParam("PlayerID") String playerId, @HeaderParam("Accept") String accept,
	        @HeaderParam("Content-Type") String contentType, ProfileBodyParam param);

	@POST
	@Path("/leaderboard/{event}/scores/crewmembers")
	@Produces
	ScoreEvent eventLeaderboard(@HeaderParam("Authorization") String auth, @HeaderParam("User-Agent") String userAgent,
	        @HeaderParam("PIDValidationToken") String pidToken, @HeaderParam("PlayerID") String playerId,
	        @PathParam("event") String event, @HeaderParam("Content-Type") String contentType, CrewBodyParam param);

}
