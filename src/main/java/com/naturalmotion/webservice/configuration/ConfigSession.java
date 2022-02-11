package com.naturalmotion.webservice.configuration;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naturalmotion.webservice.configuration.json.Auth;

public class ConfigSession {

	private final Logger log = Logger.getLogger(ConfigSession.class);

	private com.naturalmotion.webservice.configuration.json.Configuration configurationJson;

	public ConfigSession(Configuration config) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			configurationJson = mapper.readValue(
			        new File(config.getString("working.directory") + "/SESSIONS/sessions.json"),
			        com.naturalmotion.webservice.configuration.json.Configuration.class);
		} catch (IOException e) {
			log.error("Error building configuration", e);
			throw new IllegalArgumentException(e);
		}
	}

	public Auth get(String key) {
		return configurationJson.getSessions().get(key);
	}

	public Map<String, Auth> get() {
		return configurationJson.getSessions();
	}

}
