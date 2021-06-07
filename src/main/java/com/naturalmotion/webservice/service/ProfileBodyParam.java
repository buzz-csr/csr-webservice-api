package com.naturalmotion.webservice.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.naturalmotion.webservice.service.json.profile.NonSecureBlob;
import com.naturalmotion.webservice.service.json.profile.SecureBlob;
import com.naturalmotion.webservice.service.json.profile.Transaction;

public class ProfileBodyParam {

	@JsonProperty("app_ver")
	private String appVersion;

	private NonSecureBlob nonsecureBlob;

	@JsonProperty("non_secure_hash")
	private String nonSecureHash;

	@JsonProperty("non_secure_hash_alt")
	private String nonSecureHashAlt;

	private SecureBlob secureBlob;

	@JsonProperty("secure_hash")
	private String secureHash;

	@JsonProperty("secure_hash_alt")
	private String secureHashAlt;

	private List<Transaction> transactions;

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public NonSecureBlob getNonsecureBlob() {
		return nonsecureBlob;
	}

	public void setNonsecureBlob(NonSecureBlob nonsecureBlob) {
		this.nonsecureBlob = nonsecureBlob;
	}

	public String getNonSecureHash() {
		return nonSecureHash;
	}

	public void setNonSecureHash(String nonSecureHash) {
		this.nonSecureHash = nonSecureHash;
	}

	public String getNonoSecureHashAlt() {
		return nonSecureHashAlt;
	}

	public void setNonSecureHashAlt(String nonSecureHashAlt) {
		this.nonSecureHashAlt = nonSecureHashAlt;
	}

	public SecureBlob getSecureBlob() {
		return secureBlob;
	}

	public void setSecureBlob(SecureBlob secureBlob) {
		this.secureBlob = secureBlob;
	}

	public String getSecureHash() {
		return secureHash;
	}

	public void setSecureHash(String secureHash) {
		this.secureHash = secureHash;
	}

	public String getSecureHashAlt() {
		return secureHashAlt;
	}

	public void setSecureHashAlt(String secureHashAlt) {
		this.secureHashAlt = secureHashAlt;
	}

	public String getNonSecureHashAlt() {
		return nonSecureHashAlt;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
