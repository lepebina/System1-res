package com.ice.automation.events.textconfiguration;

import org.springframework.stereotype.Component;

@Component
public class TextKeyEvent {
	private Object subId;

	public Object getSubId() {
		return subId;
	}

	public void setSubId(Object subId) {
		this.subId = subId;
	}

	public enum smart_field {today,msisdn,totalCharges}
	String apiUrl = null;
	String msisdn;
	String language;
    String textKey;
	private String response;

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public String getLanguage() {
		return language;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

    public String getTextKey() {
        return textKey;
    }

    public void setTextKey(String textKey) {
        this.textKey = textKey;
    }

    public String getApiUrl() {
		if (apiUrl == null) {
			apiUrl = "ice-app/api/text/";
		}
		return apiUrl;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getResponse() {
		return response;
	}
}