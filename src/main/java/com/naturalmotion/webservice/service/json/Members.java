package com.naturalmotion.webservice.service.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Members {

	private List<ScoreMember> scores;

	public List<ScoreMember> getScores() {
		return scores;
	}

	public void setScores(List<ScoreMember> scores) {
		this.scores = scores;
	}

}
