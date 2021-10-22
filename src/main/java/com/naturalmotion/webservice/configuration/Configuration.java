package com.naturalmotion.webservice.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Configuration {

	private final Properties properties;

	private Pattern pattern = Pattern.compile(",");

	public Configuration() {
		properties = new Properties();
		try {
			InputStream resourceAsStream = Configuration.class.getClassLoader()
					.getResourceAsStream("configuration.properties");
			properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getString(String key) {
		return properties.getProperty(key);
	}

	public List<String> getList(String key) {
		String values = getString(key);
		return pattern.splitAsStream(values).collect(Collectors.toList());
	}
}
