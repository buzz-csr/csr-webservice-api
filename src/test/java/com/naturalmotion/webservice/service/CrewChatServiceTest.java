package com.naturalmotion.webservice.service;

import java.util.ArrayList;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import com.naturalmotion.webservice.service.json.tchat.Conversation;
import com.naturalmotion.webservice.service.json.tchat.params.ChatBodyParams;
import com.naturalmotion.webservice.service.json.tchat.params.Filters;
import com.naturalmotion.webservice.service.json.tchat.params.Range;

public class CrewChatServiceTest {

	private CrewChatService service = new CrewChatService();

	@Test
	@Ignore
	public void testConversations() throws Exception {
		ChatBodyParams bodyParams = new ChatBodyParams();
		bodyParams.setIds(new ArrayList<>());
//		bodyParams.getIds().add("crew_chat_id_25960299");
		bodyParams.getIds().add("crew_events_id_25960299");
//		bodyParams.getIds().add("crew_chat_id_18516329");
		bodyParams.getIds().add("crew_events_id_18516329");

		Filters filters = new Filters();
		ArrayList<String> attrs = new ArrayList<String>();
		attrs.add("messages");
		filters.setAttrs(attrs);
		Range range = new Range();
		range.setLimit("100");
		filters.setRange(range);
		bodyParams.setFilters(filters);
		Map<String, Conversation> conversations = service.conversations(
				"token YzVlNGI3ZmYyNWNjNjNiODcwM2I3MjMwODZhMmMwNjMyODU5ZmIxYzZlNmM0MjFlODZkNWUxYWVlNjMxNzQ4MXxubXw4MzQwODk3NzM2OXw1MDAyOTQ0fDE2MzE4MDUyNzc=",
				"app=customstreetracer2; ver=3.0.2; dev=iPad7,3; os=iOS; osver=14.2; res=1920x1440", "application/json",
				"application/json", bodyParams);
		Assertions.assertThat(conversations).isNotNull();
	}
}
