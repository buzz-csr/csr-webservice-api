package com.naturalmotion.webservice.configuration;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ConfigSessionTest {

	@Test
	public void testGetString() {
		ConfigSession configSession = new ConfigSession(new Configuration());
		Assertions.assertThat(configSession.get("73336037157")).isNotNull();
	}

}
