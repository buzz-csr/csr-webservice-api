package com.naturalmotion.webservice.service.json.profile;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExtraBuilder {

	private Boolean updateBs;// Boolean true
	private String smpOpponentId;
	private Integer garageIndex;
	private Integer carUid;
	private Integer ladderEventId;
	private String opponentId;
	private String raceId;
	private Integer opponentActionResult;
	private String raceSignature;
	private String raceTimestamp;
	private Boolean racestate;
	private String winnerCarId;
	private String loserCarId;
	private Boolean leaguesEnabled;
	private Boolean opponentLeaguesEnabled;
	private Integer clientPhysicsVersion;
	@JsonProperty("user_inputs")
	private UserInputs userInputs;

	public ExtraBuilder updateBs(Boolean updateBs) {
		this.updateBs = updateBs;
		return this;
	}

	public ExtraBuilder smpOpponentId(String smpOpponentId) {
		this.smpOpponentId = smpOpponentId;
		return this;
	}

	public ExtraBuilder garageIndex(Integer garageIndex) {
		this.garageIndex = garageIndex;
		return this;
	}

	public ExtraBuilder carUid(Integer carUid) {
		this.carUid = carUid;
		return this;
	}

	public ExtraBuilder ladderEventId(Integer ladderEventId) {
		this.ladderEventId = ladderEventId;
		return this;
	}

	public ExtraBuilder opponentId(String opponentId) {
		this.opponentId = opponentId;
		return this;
	}

	public ExtraBuilder raceId(String raceId) {
		this.raceId = raceId;
		return this;
	}

	public ExtraBuilder opponentActionResult(Integer opponentActionResult) {
		this.opponentActionResult = opponentActionResult;
		return this;
	}

	public ExtraBuilder raceSignature(String raceSignature) {
		this.raceSignature = raceSignature;
		return this;
	}

	public ExtraBuilder raceTimestamp(String raceTimestamp) {
		this.raceTimestamp = raceTimestamp;
		return this;
	}

	public ExtraBuilder racestate(Boolean racestate) {
		this.racestate = racestate;
		return this;
	}

	public ExtraBuilder winnerCarId(String winnerCarId) {
		this.winnerCarId = winnerCarId;
		return this;
	}

	public ExtraBuilder loserCarId(String loserCarId) {
		this.loserCarId = loserCarId;
		return this;
	}

	public ExtraBuilder leaguesEnabled(Boolean leaguesEnabled) {
		this.leaguesEnabled = leaguesEnabled;
		return this;
	}

	public ExtraBuilder opponentLeaguesEnabled(Boolean opponentLeaguesEnabled) {
		this.opponentLeaguesEnabled = opponentLeaguesEnabled;
		return this;
	}

	public ExtraBuilder clientPhysicsVersion(Integer clientPhysicsVersion) {
		this.clientPhysicsVersion = clientPhysicsVersion;
		return this;
	}

	public ExtraBuilder userInputs(int input1, int input2, int input3, int input4, int input5, int input6, int input7,
			int input8, double lunchRpm, Integer numEvents, double clutch) {
		List<Integer> inputEvents = new ArrayList<>();
		inputEvents.add(input1);
		inputEvents.add(input2);
		inputEvents.add(input3);
		inputEvents.add(input4);
		inputEvents.add(input5);
		inputEvents.add(input6);
		inputEvents.add(input7);
		inputEvents.add(input8);
		userInputs = new UserInputs();
		userInputs.setInputEvents(inputEvents);
		userInputs.setLaunchRPM(lunchRpm);
		userInputs.setNumEvents(numEvents);
		userInputs.setClutchEngagedTime(clutch);
		return this;
	}

	public Extra build() {
		Extra extra = new Extra();
		if (carUid != null) {
			extra.setCarUid(carUid);
		}
		if (clientPhysicsVersion != null) {
			extra.setClientPhysicsVersion(clientPhysicsVersion);
		}
		if (garageIndex != null) {
			extra.setGarageIndex(garageIndex);
		}
		if (ladderEventId != null) {
			extra.setLadderEventId(ladderEventId);
		}
		if (leaguesEnabled != null) {
			extra.setLeaguesEnabled(leaguesEnabled);
		}
		if (loserCarId != null) {
			extra.setLoserCarId(loserCarId);
		}
		if (opponentActionResult != null) {
			extra.setOpponentActionResult(opponentActionResult);
		}
		if (opponentId != null) {
			extra.setOpponentId(opponentId);
		}
		if (opponentLeaguesEnabled != null) {
			extra.setOpponentLeaguesEnabled(opponentLeaguesEnabled);
		}
		if (raceId != null) {
			extra.setRaceId(raceId);
		}
		if (raceSignature != null) {
			extra.setRaceSignature(raceSignature);
		}
		if (racestate != null) {
			extra.setRacestate(racestate);
		}
		if (raceTimestamp != null) {
			extra.setRaceTimestamp(raceTimestamp);
		}
		if (smpOpponentId != null) {
			extra.setSmpOpponentId(smpOpponentId);
		}
		if (updateBs != null) {
			extra.setUpdateBs(updateBs);
		}
		if (userInputs != null) {
			extra.setUserInputs(userInputs);
		}
		if (winnerCarId != null) {
			extra.setWinnerCarId(winnerCarId);
		}
		return extra;
	}

}
