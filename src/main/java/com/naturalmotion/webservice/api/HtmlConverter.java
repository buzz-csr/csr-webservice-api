package com.naturalmotion.webservice.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlConverter {

	private Pattern globalColorPattern = Pattern.compile("(.*)(\\[[0-9a-zA-Z]{6}\\])(.*)");
	private Pattern colorPattern = Pattern.compile("^\\[([0-9a-zA-Z]{6})\\]$");
	private Pattern italicPattern = Pattern.compile("^(.*)\\[i\\](.*)$");

	public String convert(String input) {

		StringBuilder result = convertItalic(input);

		return convertColor(result.toString());
	}

	private StringBuilder convertItalic(String input) {
		StringBuilder result = new StringBuilder();
		Matcher matcher = italicPattern.matcher(input);
		if (matcher.find()) {
			result.append(matcher.group(1)).append("<i>").append(matcher.group(2)).append("</i>");
		} else {
			result.append(input);
		}
		return result;
	}

	private String convertColor(String input) {
		StringBuilder result = new StringBuilder();

		boolean closeSpan = false;
		Matcher matcher = globalColorPattern.matcher(input);
		if (matcher.find()) {
			int groupCount = matcher.groupCount();
			for (int i = 1; i <= groupCount; i++) {
				String group = matcher.group(i);

				Matcher colorMatcher = colorPattern.matcher(group);
				if (colorMatcher.find()) {
					if (closeSpan) {
						result.append("</span>");
					}
					closeSpan = true;
					result.append("<span style=\"color: #" + colorMatcher.group(1) + "\" >");
				} else if (globalColorPattern.matcher(group).find()) {
					result.append(convertColor(group));
				} else {
					result.append(group);
				}
			}
		} else {
			result.append(input);
		}
		if (closeSpan) {
			result.append("</span>");
		}
		return result.toString();
	}
}
