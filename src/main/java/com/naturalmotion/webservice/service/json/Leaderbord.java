package com.naturalmotion.webservice.service.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Leaderbord {

	private List<ScoreCrew> scores;

	public List<ScoreCrew> getScores() {
		return scores;
	}

	public void setScores(List<ScoreCrew> scores) {
		this.scores = scores;
	}

}
