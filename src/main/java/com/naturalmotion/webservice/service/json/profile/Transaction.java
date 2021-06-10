package com.naturalmotion.webservice.service.json.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Transaction {

	private String action; // String TrackedParameterChanged
	private long timestamp;// Integer 1622121289
	private Integer increase;// Integer 1
	private String reason;// String Session
	private Integer boost;
	@JsonProperty("crew_uid")
	private String crewUid;
	@JsonProperty("action_result")
	private Integer actionResult;
	@JsonProperty("event_id")
	private String eventid;
	@JsonProperty("series_id")
	private String seriesId;

	private Extra extra;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getIncrease() {
		return increase;
	}

	public void setIncrease(Integer increase) {
		this.increase = increase;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Extra getExtra() {
		return extra;
	}

	public void setExtra(Extra extra) {
		this.extra = extra;
	}

	public Integer getBoost() {
		return boost;
	}

	public void setBoost(Integer boost) {
		this.boost = boost;
	}

	public String getCrewUid() {
		return crewUid;
	}

	public void setCrewUid(String crewUid) {
		this.crewUid = crewUid;
	}

	public Integer getActionResult() {
		return actionResult;
	}

	public void setActionResult(Integer actionResult) {
		this.actionResult = actionResult;
	}

	public String getEventid() {
		return eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public String getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}

}
