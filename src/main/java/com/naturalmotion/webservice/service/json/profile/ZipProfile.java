package com.naturalmotion.webservice.service.json.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ZipProfile {

	private NonSecureBlob nonsecureBlob;

	@JsonProperty("non_secure_hash")
	private String nonSecureHash;

	private SecureBlob secureBlob;

	@JsonProperty("secure_hash")
	private String secureHash;

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

}
