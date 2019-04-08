package com.ice.automation.events.blacklist;

import org.springframework.stereotype.Component;

@Component
public class BlacklistEvent {
	String apiUrl;
	String msisdn;

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getApiUrl() {
		if (apiUrl == null) {
			apiUrl = "ice-app/api/blacklist";
		}
		return apiUrl;
	}
}