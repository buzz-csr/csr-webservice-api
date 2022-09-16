package com.naturalmotion.webservice.service;

import java.util.Arrays;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class LineService {

	private static final String HOST = "https://gwu.line.naver.jp/";

	private Line line;

	public LineService() {
		line = JAXRSClientFactory.create(HOST, Line.class, Arrays.asList(new JacksonJsonProvider()));
	}

	public Object push() {
		return line.push("application/x-thrift", "application/x-thrift", "Line/12.3.2", "en_US",
		        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJmNzYwNjk0OC05MWJiLTQ2ZDYtOWFkZi02Zjc3NDliNjY3OWQiLCJhdWQiOiJMSU5FIiwiaWF0IjoxNjQ4NDE0MzU1LCJleHAiOjE2NDkwMTkxNTUsInNjcCI6IkxJTkVfQ09SRSIsInJ0aWQiOiIxZjA1M2ViYS1kMDQ4LTRlY2EtYmZkNi1kMDRhZThjMzkyMmEiLCJyZXhwIjoxODA2MDk0MzU1LCJ2ZXIiOiIzLjEiLCJhaWQiOiJ1NjM4OGI2YTc0NTQyZDAzNTVkOTJiMTI3NjdlYzEwZTUiLCJsc2lkIjoiYjRhNTYzMDItYTVmMS00OGY2LWE3YmUtZGFkNjE4YmM0MjA4IiwiZGlkIjoiZWI4MjM4MDZkYmU5NDZkZGRiNzdkMDAzZmUzMDEyYTIiLCJjdHlwZSI6IkFORFJPSUQiLCJjbW9kZSI6IlBSSU1BUlkiLCJjaWQiOiIwMDAwMDAwMDAwIn0.gBcyRlwT4p5UqQL3x7hc2EpIRD8EAQr9PQvW9dPxFbA",
		        "ANDROID 12.3.2 Android OS 9", "1", null);
	}

	public Object push2() {
		return line.push2("gzip", "application/octet-stream", "chunked", "Line/12.3.2", "en_US",
		        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJmNzYwNjk0OC05MWJiLTQ2ZDYtOWFkZi02Zjc3NDliNjY3OWQiLCJhdWQiOiJMSU5FIiwiaWF0IjoxNjQ4NDE0MzU1LCJleHAiOjE2NDkwMTkxNTUsInNjcCI6IkxJTkVfQ09SRSIsInJ0aWQiOiIxZjA1M2ViYS1kMDQ4LTRlY2EtYmZkNi1kMDRhZThjMzkyMmEiLCJyZXhwIjoxODA2MDk0MzU1LCJ2ZXIiOiIzLjEiLCJhaWQiOiJ1NjM4OGI2YTc0NTQyZDAzNTVkOTJiMTI3NjdlYzEwZTUiLCJsc2lkIjoiYjRhNTYzMDItYTVmMS00OGY2LWE3YmUtZGFkNjE4YmM0MjA4IiwiZGlkIjoiZWI4MjM4MDZkYmU5NDZkZGRiNzdkMDAzZmUzMDEyYTIiLCJjdHlwZSI6IkFORFJPSUQiLCJjbW9kZSI6IlBSSU1BUlkiLCJjaWQiOiIwMDAwMDAwMDAwIn0.gBcyRlwT4p5UqQL3x7hc2EpIRD8EAQr9PQvW9dPxFbA",
		        "ANDROID 12.3.2 Android OS 9", 1, "");
	}
}
