package com.naturalmotion.webservice.service.json.profile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TunerCustomSetup {

	@JsonProperty("BODYKIT")
	private int bodykit;
	@JsonProperty("WHEELS")
	private int wheels;
	@JsonProperty("WING")
	private int wing;
	@JsonProperty("BOOST_COLOR")
	private int boostColor;
	@JsonProperty("HOOD")
	private int hood;
	@JsonProperty("RIMS")
	private int rims;
	@JsonProperty("TIRE")
	private int tire;

	public int getBodykit() {
		return bodykit;
	}

	public void setBodykit(int bodykit) {
		this.bodykit = bodykit;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public int getWing() {
		return wing;
	}

	public void setWing(int wing) {
		this.wing = wing;
	}

	public int getBoostColor() {
		return boostColor;
	}

	public void setBoostColor(int boostColor) {
		this.boostColor = boostColor;
	}

	public int getHood() {
		return hood;
	}

	public void setHood(int hood) {
		this.hood = hood;
	}

	public int getRims() {
		return rims;
	}

	public void setRims(int rims) {
		this.rims = rims;
	}

	public int getTire() {
		return tire;
	}

	public void setTire(int tire) {
		this.tire = tire;
	}

}
