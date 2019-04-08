package com.ice.automation.events.refresh;

import org.springframework.stereotype.Component;

@Component
public class RefreshEvent {
	String apiUrl;

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getApiUrl() {
		if (apiUrl == null) {
			apiUrl = "ice-app/api/cache/clear";
		}
		return apiUrl;
	}
}