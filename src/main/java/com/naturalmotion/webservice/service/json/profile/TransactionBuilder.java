package com.naturalmotion.webservice.service.json.profile;

public class TransactionBuilder {

	private String action; // String TrackedParameterChanged
	private long timestamp;// Integer 1622121289
	private Integer increase;// Integer 1
	private String reason;// String Session
	private Integer boost;
	private String crewUid;
	private Integer actionResult;
	private String eventid;
	private String seriesId;
	private ExtraBuilder extra;

	public TransactionBuilder action(String action) {
		this.action = action;
		return this;
	}

	public TransactionBuilder timestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public TransactionBuilder increase(Integer increase) {
		this.increase = increase;
		return this;
	}

	public TransactionBuilder reason(String reason) {
		this.reason = reason;
		return this;
	}

	public TransactionBuilder boost(Integer boost) {
		this.boost = boost;
		return this;
	}

	public TransactionBuilder crewUid(String crewUid) {
		this.crewUid = crewUid;
		return this;
	}

	public TransactionBuilder actionResult(Integer actionResult) {
		this.actionResult = actionResult;
		return this;
	}

	public TransactionBuilder eventid(String eventid) {
		this.eventid = eventid;
		return this;
	}

	public TransactionBuilder seriesId(String seriesId) {
		this.seriesId = seriesId;
		return this;
	}

	public TransactionBuilder extra(ExtraBuilder extra) {
		this.extra = extra;
		return this;
	}

	public Transaction build() {
		Transaction transaction = new Transaction();
		if (extra != null) {
			transaction.setExtra(extra.build());
		}
		if (action != null) {
			transaction.setAction(action);
		}
		if (actionResult != null) {
			transaction.setActionResult(actionResult);
		}
		if (boost != null) {
			transaction.setBoost(boost);
		}
		if (crewUid != null) {
			transaction.setCrewUid(crewUid);
		}
		if (eventid != null) {
			transaction.setEventid(eventid);
		}
		if (increase != null) {
			transaction.setIncrease(increase);
		}
		if (reason != null) {
			transaction.setReason(reason);
		}
		if (seriesId != null) {
			transaction.setSeriesId(seriesId);
		}
		transaction.setTimestamp(timestamp);
		return transaction;
	}
}
