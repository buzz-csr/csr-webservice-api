package com.naturalmotion.webservice.service.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Login {

	@JsonProperty("non_secure_hash")
	private String nonSecureHash;

	@JsonProperty("secure_hash")
	private String secureHash;

	@JsonProperty("account_hash")
	private String accountHash;

	public String getNonSecureHash() {
		return nonSecureHash;
	}

	public void setNonSecureHash(String nonSecureHash) {
		this.nonSecureHash = nonSecureHash;
	}

	public String getSecureHash() {
		return secureHash;
	}

	public void setSecureHash(String secureHash) {
		this.secureHash = secureHash;
	}

	public String getAccountHash() {
		return accountHash;
	}

	public void setAccountHash(String accountHash) {
		this.accountHash = accountHash;
	}

}
