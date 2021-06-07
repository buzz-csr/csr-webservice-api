package com.naturalmotion.webservice.service.json.tchat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {

	private String zid;

	private String rarity;

	@JsonProperty("paid_delta")
	private int paidDelta;

	public String getZid() {
		return zid;
	}

	public void setZid(String zid) {
		this.zid = zid;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public int getPaidDelta() {
		return paidDelta;
	}

	public void setPaidDelta(int paidDelta) {
		this.paidDelta = paidDelta;
	}

}
