package com.ice.automation.events.delete;


import org.springframework.stereotype.Component;

@Component
public class DeleteEvent {
	String apiUrl;
	String msisdn;

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getApiUrl() {
		if (apiUrl == null) {
			apiUrl = "ice-app/api/customer";
		}
		return apiUrl;
	}
}