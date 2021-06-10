package com.naturalmotion.webservice.service.json.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Extra {

	@JsonProperty("update_bs")
	private Boolean updateBs;// Boolean true
	@JsonProperty("smp_opponent_id")
	private String smpOpponentId;
	@JsonProperty("garage_index")
	private Integer garageIndex;
	@JsonProperty("car_uid")
	private Integer carUid;
	@JsonProperty("ladder_event_id")
	private Integer ladderEventId;
	@JsonProperty("opponent_id")
	private String opponentId;
	@JsonProperty("race_id")
	private String raceId;
	@JsonProperty("opponent_action_result")
	private Integer opponentActionResult;
	@JsonProperty("race_signature")
	private String raceSignature;
	@JsonProperty("race_timestamp")
	private String raceTimestamp;
	@JsonProperty("racestate")
	private Boolean racestate;
	@JsonProperty("winner_car_id")
	private String winnerCarId;
	@JsonProperty("loser_car_id")
	private String loserCarId;
	@JsonProperty("leagues_enabled")
	private Boolean leaguesEnabled;
	@JsonProperty("opponent_leagues_enabled")
	private Boolean opponentLeaguesEnabled;
	@JsonProperty("client_physics_version")
	private Integer clientPhysicsVersion;
	@JsonProperty("user_inputs")
	private UserInputs userInputs;

	public Boolean isUpdateBs() {
		return updateBs;
	}

	public void setUpdateBs(Boolean updateBs) {
		this.updateBs = updateBs;
	}

	public String getSmpOpponentId() {
		return smpOpponentId;
	}

	public void setSmpOpponentId(String smpOpponentId) {
		this.smpOpponentId = smpOpponentId;
	}

	public Integer getGarageIndex() {
		return garageIndex;
	}

	public void setGarageIndex(Integer garageIndex) {
		this.garageIndex = garageIndex;
	}

	public Integer getCarUid() {
		return carUid;
	}

	public void setCarUid(Integer carUid) {
		this.carUid = carUid;
	}

	public Integer getLadderEventId() {
		return ladderEventId;
	}

	public void setLadderEventId(Integer ladderEventId) {
		this.ladderEventId = ladderEventId;
	}

	public String getOpponentId() {
		return opponentId;
	}

	public void setOpponentId(String opponentId) {
		this.opponentId = opponentId;
	}

	public String getRaceId() {
		return raceId;
	}

	public void setRaceId(String raceId) {
		this.raceId = raceId;
	}

	public Integer getOpponentActionResult() {
		return opponentActionResult;
	}

	public void setOpponentActionResult(Integer opponentActionResult) {
		this.opponentActionResult = opponentActionResult;
	}

	public String getRaceSignature() {
		return raceSignature;
	}

	public void setRaceSignature(String raceSignature) {
		this.raceSignature = raceSignature;
	}

	public String getRaceTimestamp() {
		return raceTimestamp;
	}

	public void setRaceTimestamp(String raceTimestamp) {
		this.raceTimestamp = raceTimestamp;
	}

	public Boolean isRacestate() {
		return racestate;
	}

	public void setRacestate(Boolean racestate) {
		this.racestate = racestate;
	}

	public String getWinnerCarId() {
		return winnerCarId;
	}

	public void setWinnerCarId(String winnerCarId) {
		this.winnerCarId = winnerCarId;
	}

	public String getLoserCarId() {
		return loserCarId;
	}

	public void setLoserCarId(String loserCarId) {
		this.loserCarId = loserCarId;
	}

	public Boolean isLeaguesEnabled() {
		return leaguesEnabled;
	}

	public void setLeaguesEnabled(Boolean leaguesEnabled) {
		this.leaguesEnabled = leaguesEnabled;
	}

	public Boolean isOpponentLeaguesEnabled() {
		return opponentLeaguesEnabled;
	}

	public void setOpponentLeaguesEnabled(Boolean opponentLeaguesEnabled) {
		this.opponentLeaguesEnabled = opponentLeaguesEnabled;
	}

	public Integer getClientPhysicsVersion() {
		return clientPhysicsVersion;
	}

	public void setClientPhysicsVersion(Integer clientPhysicsVersion) {
		this.clientPhysicsVersion = clientPhysicsVersion;
	}

	public UserInputs getUserInputs() {
		return userInputs;
	}

	public void setUserInputs(UserInputs userInputs) {
		this.userInputs = userInputs;
	}

}
