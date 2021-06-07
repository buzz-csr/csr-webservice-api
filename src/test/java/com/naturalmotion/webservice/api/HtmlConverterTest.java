package com.naturalmotion.webservice.api;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class HtmlConverterTest {

	private HtmlConverter htmlConverter = new HtmlConverter();

	@Test
	public void testConvertOneBalise() throws Exception {
		Assertions.assertThat(htmlConverter.convert("abcd[001122]efg"))
				.isEqualTo("abcd<span style=\"color: #001122\" >efg</span>");
		Assertions.assertThat(htmlConverter.convert("[001122]abcdefg"))
				.isEqualTo("<span style=\"color: #001122\" >abcdefg</span>");
	}

	@Test
	public void testConvertMultipleBalise() throws Exception {
		Assertions.assertThat(htmlConverter.convert("abcd[001122]efg[123456]hij"))
				.isEqualTo("abcd<span style=\"color: #001122\" >efg</span><span style=\"color: #123456\" >hij</span>");
	}

	@Test
	public void testConvertItalic() throws Exception {
		Assertions.assertThat(htmlConverter.convert("abcd[i]efg")).isEqualTo("abcd<i>efg</i>");
		Assertions.assertThat(htmlConverter.convert("[i]abcdefg")).isEqualTo("<i>abcdefg</i>");
	}

	@Test
	public void testConvertItalicAndColor() throws Exception {
		Assertions.assertThat(htmlConverter.convert("[001122]abcd[i]efg"))
				.isEqualTo("<span style=\"color: #001122\" >abcd<i>efg</i></span>");
	}

}
