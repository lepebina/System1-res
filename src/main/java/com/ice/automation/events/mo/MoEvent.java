package com.ice.automation.events.mo;

import org.springframework.stereotype.Component;

@Component
public class MoEvent {
	String apiUrl;
	String moId;
	String sender;
	String recipient;
	String payload;

	public void setMoId(String moId) {
		this.moId = moId;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getMoId() {
		return moId;
	}

	public String getSender() {
		return sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public String getPayload() {
		return payload;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getApiUrl() {
		if (apiUrl == null) {
			apiUrl = "ice-app/api/mo";
		}
		return apiUrl;
	}
}