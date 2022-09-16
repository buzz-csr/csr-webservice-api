package com.naturalmotion.webservice.service;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

@Path("/")
@Component
public interface Line {

	@POST
	@Path("/S4")
	@Produces
	Object push(@HeaderParam("Accept") String accept, @HeaderParam("Content-Type") String type,
	        @HeaderParam("user-agent") String userAgent, @HeaderParam("x-lal") String language,
	        @HeaderParam("x-line-access") String lineAccess, @HeaderParam("x-line-application") String lineApp,
	        @HeaderParam("x-lpv") String lpv, String body);

	@POST
	@Path("/PUSH/1/subs")
	@Produces
	Object push2(@HeaderParam("accept-encoding") String accept, @HeaderParam("Content-Type") String type,
	        @HeaderParam("transfer-encoding") String transEncod, @HeaderParam("user-agent") String userAgent,
	        @HeaderParam("x-lal") String language, @HeaderParam("x-line-access") String lineAccess,
	        @HeaderParam("x-line-application") String lineApp, @HeaderParam("x-lpv") int lpv, String body);
}
