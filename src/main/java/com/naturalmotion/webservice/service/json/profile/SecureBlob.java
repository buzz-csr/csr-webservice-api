package com.naturalmotion.webservice.service.json.profile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class SecureBlob {

	@JsonProperty("CashEarned")
	private int cashEarned;
	@JsonProperty("CashSpent")
	private int cashSpent;
	@JsonProperty("GoldEarned")
	private int goldEarned;
	@JsonProperty("GoldSpent")
	private int goldSpent;
	@JsonProperty("GachaSilverKeysSpent")
	private int gachaSilverKeysSpent;
	@JsonProperty("GachaBronzeKeysEarned")
	private int gachaBronzeKeysEarned;
	@JsonProperty("GachaBronzeKeysSpent")
	private int gachaBronzeKeysSpent;
	@JsonProperty("GachaSilverKeysEarned")
	private int gachaSilverKeysEarned;
	@JsonProperty("GachaGoldKeysEarned")
	private int gachaGoldKeysEarned;
	@JsonProperty("GachaGoldKeysSpent")
	private int gachaGoldKeysSpent;
	@JsonProperty("RP")
	private int rp;
	@JsonProperty("RacesInCrewEarned")
	private int racesInCrewEarned;
	@JsonProperty("RacesInCrewSpent")
	private int racesInCrewSpent;
	@JsonProperty("AMPartGreenEarned")
	private int amPartGreenEarned;
	@JsonProperty("AMPartBlueEarned")
	private int amPartBlueEarned;
	@JsonProperty("AMPartRedEarned")
	private int amPartRedEarned;
	@JsonProperty("AMPartYellowEarned")
	private int amPartYellowEarned;
	@JsonProperty("AMPartGreenSpent")
	private int amPartGreenSpent;
	@JsonProperty("AMPartBlueSpent")
	private int amPartBlueSpent;
	@JsonProperty("AMPartRedSpent")
	private int amPartRedSpent;
	@JsonProperty("AMPartYellowSpent")
	private int amPartYellowSpent;
	@JsonProperty("RestorationPartsEarned")
	private JsonNode restorationPartsEarned;
	@JsonProperty("RestorationPartsSpent")
	private JsonNode restorationPartsSpent;
	@JsonProperty("FlexibleCurrenciesEarned")
	private JsonNode flexibleCurrenciesEarned;
	@JsonProperty("FlexibleCurrenciesSpent")
	private JsonNode flexibleCurrenciesSpent;
	@JsonProperty("CarsSecureData")
	private JsonNode carsSecureData;

	public int getCashEarned() {
		return cashEarned;
	}

	public void setCashEarned(int cashEarned) {
		this.cashEarned = cashEarned;
	}

	public int getCashSpent() {
		return cashSpent;
	}

	public void setCashSpent(int cashSpent) {
		this.cashSpent = cashSpent;
	}

	public int getGoldEarned() {
		return goldEarned;
	}

	public void setGoldEarned(int goldEarned) {
		this.goldEarned = goldEarned;
	}

	public int getGoldSpent() {
		return goldSpent;
	}

	public void setGoldSpent(int goldSpent) {
		this.goldSpent = goldSpent;
	}

	public int getGachaSilverKeysSpent() {
		return gachaSilverKeysSpent;
	}

	public void setGachaSilverKeysSpent(int gachaSilverKeysSpent) {
		this.gachaSilverKeysSpent = gachaSilverKeysSpent;
	}

	public int getGachaBronzeKeysEarned() {
		return gachaBronzeKeysEarned;
	}

	public void setGachaBronzeKeysEarned(int gachaBronzeKeysEarned) {
		this.gachaBronzeKeysEarned = gachaBronzeKeysEarned;
	}

	public int getGachaBronzeKeysSpent() {
		return gachaBronzeKeysSpent;
	}

	public void setGachaBronzeKeysSpent(int gachaBronzeKeysSpent) {
		this.gachaBronzeKeysSpent = gachaBronzeKeysSpent;
	}

	public int getGachaSilverKeysEarned() {
		return gachaSilverKeysEarned;
	}

	public void setGachaSilverKeysEarned(int gachaSilverKeysEarned) {
		this.gachaSilverKeysEarned = gachaSilverKeysEarned;
	}

	public int getGachaGoldKeysEarned() {
		return gachaGoldKeysEarned;
	}

	public void setGachaGoldKeysEarned(int gachaGoldKeysEarned) {
		this.gachaGoldKeysEarned = gachaGoldKeysEarned;
	}

	public int getGachaGoldKeysSpent() {
		return gachaGoldKeysSpent;
	}

	public void setGachaGoldKeysSpent(int gachaGoldKeysSpent) {
		this.gachaGoldKeysSpent = gachaGoldKeysSpent;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getRacesInCrewEarned() {
		return racesInCrewEarned;
	}

	public void setRacesInCrewEarned(int racesInCrewEarned) {
		this.racesInCrewEarned = racesInCrewEarned;
	}

	public int getRacesInCrewSpent() {
		return racesInCrewSpent;
	}

	public void setRacesInCrewSpent(int racesInCrewSpent) {
		this.racesInCrewSpent = racesInCrewSpent;
	}

	public int getAmPartGreenEarned() {
		return amPartGreenEarned;
	}

	public void setAmPartGreenEarned(int amPartGreenEarned) {
		this.amPartGreenEarned = amPartGreenEarned;
	}

	public int getAmPartBlueEarned() {
		return amPartBlueEarned;
	}

	public void setAmPartBlueEarned(int amPartBlueEarned) {
		this.amPartBlueEarned = amPartBlueEarned;
	}

	public int getAmPartRedEarned() {
		return amPartRedEarned;
	}

	public void setAmPartRedEarned(int amPartRedEarned) {
		this.amPartRedEarned = amPartRedEarned;
	}

	public int getAmPartYellowEarned() {
		return amPartYellowEarned;
	}

	public void setAmPartYellowEarned(int amPartYellowEarned) {
		this.amPartYellowEarned = amPartYellowEarned;
	}

	public int getAmPartGreenSpent() {
		return amPartGreenSpent;
	}

	public void setAmPartGreenSpent(int amPartGreenSpent) {
		this.amPartGreenSpent = amPartGreenSpent;
	}

	public int getAmPartBlueSpent() {
		return amPartBlueSpent;
	}

	public void setAmPartBlueSpent(int amPartBlueSpent) {
		this.amPartBlueSpent = amPartBlueSpent;
	}

	public int getAmPartRedSpent() {
		return amPartRedSpent;
	}

	public void setAmPartRedSpent(int amPartRedSpent) {
		this.amPartRedSpent = amPartRedSpent;
	}

	public int getAmPartYellowSpent() {
		return amPartYellowSpent;
	}

	public void setAmPartYellowSpent(int amPartYellowSpent) {
		this.amPartYellowSpent = amPartYellowSpent;
	}

	public JsonNode getRestorationPartsEarned() {
		return restorationPartsEarned;
	}

	public void setRestorationPartsEarned(JsonNode restorationPartsEarned) {
		this.restorationPartsEarned = restorationPartsEarned;
	}

	public JsonNode getRestorationPartsSpent() {
		return restorationPartsSpent;
	}

	public void setRestorationPartsSpent(JsonNode restorationPartsSpent) {
		this.restorationPartsSpent = restorationPartsSpent;
	}

	public JsonNode getFlexibleCurrenciesEarned() {
		return flexibleCurrenciesEarned;
	}

	public void setFlexibleCurrenciesEarned(JsonNode flexibleCurrenciesEarned) {
		this.flexibleCurrenciesEarned = flexibleCurrenciesEarned;
	}

	public JsonNode getFlexibleCurrenciesSpent() {
		return flexibleCurrenciesSpent;
	}

	public void setFlexibleCurrenciesSpent(JsonNode flexibleCurrenciesSpent) {
		this.flexibleCurrenciesSpent = flexibleCurrenciesSpent;
	}

	public JsonNode getCarsSecureData() {
		return carsSecureData;
	}

	public void setCarsSecureData(JsonNode carsSecureData) {
		this.carsSecureData = carsSecureData;
	}

}
