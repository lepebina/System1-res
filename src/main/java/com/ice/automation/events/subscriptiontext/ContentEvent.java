package com.ice.automation.events.subscriptiontext;


import org.springframework.stereotype.Component;

@Component
public class ContentEvent {
	String apiUrl;
	String subscriptionId;
	String msisdn;

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getApiUrl() {
		if (apiUrl == null) {
			apiUrl = "ice-app/api/content";
		}
		return apiUrl;
	}
}