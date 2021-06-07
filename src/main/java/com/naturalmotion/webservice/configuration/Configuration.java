package com.naturalmotion.webservice.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	private final Properties properties;

	public Configuration() {
		properties = new Properties();
		try {
			InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("configuration.properties");
			properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getString(String key) {
		return properties.getProperty(key);
	}
}
