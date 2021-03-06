package com.naturalmotion.webservice.api;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import com.naturalmotion.webservice.service.auth.Authorization;
import com.naturalmotion.webservice.service.json.event.Player;
import com.naturalmotion.webservice.service.json.tchat.Message;

public class CrewResourcesTest {

	private CrewResources resources = new CrewResources();

	@Test
	@Ignore
	public void testGetProfile() throws Exception {
		Authorization auth = new Authorization();
		auth.setAuthToken(
				"token YzVlNGI3ZmYyNWNjNjNiODcwM2I3MjMwODZhMmMwNjMyODU5ZmIxYzZlNmM0MjFlODZkNWUxYWVlNjMxNzQ4MXxubXw4MzQwODk3NzM2OXw1MDAyOTQ0fDE2MzE4MDUyNzc=");
		auth.setUserAgent("app=customstreetracer2; ver=3.0.2; dev=iPad7,3; os=iOS; osver=14.2; res=1920x1440");
		auth.setPidValidation("3eee1afc3d8087498a0af3ae3509a720195d4f38");
		auth.setPlayerId("73336037157");
		Profile profile = resources.getProfile(auth);
		Assertions.assertThat(profile).isNotNull();
		profile.getEvents().stream().forEach(x -> System.out.println(x));
	}

	@Test
	@Ignore
	public void testGetEventCrewScore() throws Exception {
		Authorization auth = new Authorization();
		auth.setAuthToken(
				"token YzVlNGI3ZmYyNWNjNjNiODcwM2I3MjMwODZhMmMwNjMyODU5ZmIxYzZlNmM0MjFlODZkNWUxYWVlNjMxNzQ4MXxubXw4MzQwODk3NzM2OXw1MDAyOTQ0fDE2MzE4MDUyNzc=");
		auth.setUserAgent("app=customstreetracer2; ver=3.0.2; dev=iPad7,3; os=iOS; osver=14.2; res=1920x1440");
		auth.setPidValidation("3eee1afc3d8087498a0af3ae3509a720195d4f38");
		auth.setPlayerId("73336037157");

		Profile profile = resources.getProfile(auth);
		String event = profile.getEvents().get(0);
		List<Player> score = resources.getEventCrewScore(auth, event);
		Assertions.assertThat(score).isNotNull();
	}

	@Test
	@Ignore
	public void testGetConversations() throws Exception {
		Authorization auth = new Authorization();
		auth.setAuthToken(
				"token YzVlNGI3ZmYyNWNjNjNiODcwM2I3MjMwODZhMmMwNjMyODU5ZmIxYzZlNmM0MjFlODZkNWUxYWVlNjMxNzQ4MXxubXw4MzQwODk3NzM2OXw1MDAyOTQ0fDE2MzE4MDUyNzc=");
		auth.setUserAgent("app=customstreetracer2; ver=3.0.2; dev=iPad7,3; os=iOS; osver=14.2; res=1920x1440");
		auth.setPlayerId("73336037157");
		List<List<Message>> conversations = resources.getConversations(auth, "25960299");
		Assertions.assertThat(conversations).hasSize(2);
	}

}
