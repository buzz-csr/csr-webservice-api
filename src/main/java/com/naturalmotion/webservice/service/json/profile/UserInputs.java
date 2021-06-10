package com.naturalmotion.webservice.service.json.profile;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInputs {

	@JsonProperty("LaunchRPM")
	private double launchRPM;
	@JsonProperty("InputEvents")
	private List<Integer> inputEvents;
	@JsonProperty("NumEvents")
	private Integer numEvents;
	@JsonProperty("ClutchEngagedTime")
	private double clutchEngagedTime;

	public double getLaunchRPM() {
		return launchRPM;
	}

	public void setLaunchRPM(double launchRPM) {
		this.launchRPM = launchRPM;
	}

	public List<Integer> getInputEvents() {
		return inputEvents;
	}

	public void setInputEvents(List<Integer> inputEvents) {
		this.inputEvents = inputEvents;
	}

	public Integer getNumEvents() {
		return numEvents;
	}

	public void setNumEvents(Integer numEvents) {
		this.numEvents = numEvents;
	}

	public double getClutchEngagedTime() {
		return clutchEngagedTime;
	}

	public void setClutchEngagedTime(double clutchEngagedTime) {
		this.clutchEngagedTime = clutchEngagedTime;
	}

}
