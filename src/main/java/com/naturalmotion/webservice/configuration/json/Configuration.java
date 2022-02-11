package com.naturalmotion.webservice.configuration.json;

import java.util.Map;

public class Configuration {

	private Map<String, Auth> sessions;

	public Map<String, Auth> getSessions() {
		return sessions;
	}

	public void setSessions(Map<String, Auth> sessions) {
		this.sessions = sessions;
	}

}
