package com.naturalmotion.webservice.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigSession {

	private final Properties properties;

	public ConfigSession(Configuration configuration) {
		properties = new Properties();

		try {
			InputStream resourceAsStream = new FileInputStream(
					configuration.getString("working.directory") + "/SESSIONS/config.properties");
			properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getString(String key) {
		return properties.getProperty(key);
	}

}
