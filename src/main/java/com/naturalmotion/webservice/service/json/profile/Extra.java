package com.naturalmotion.webservice.service.json.profile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Extra {

	@JsonProperty("update_bs")
	private boolean updateBs;// Boolean true

	public boolean isUpdateBs() {
		return updateBs;
	}

	public void setUpdateBs(boolean updateBs) {
		this.updateBs = updateBs;
	}

}
