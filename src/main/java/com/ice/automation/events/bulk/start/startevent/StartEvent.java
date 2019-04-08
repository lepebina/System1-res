package com.ice.automation.events.bulk.start.startevent;

import org.springframework.stereotype.Component;

@Component
public class StartEvent {
	String apiUrl;
	String bulkId;

	public void setBulkId(String bulkId) {
		this.bulkId = bulkId;
	}

	public String getBulkId() {
		return bulkId;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getApiUrl() {
		if (apiUrl == null) {
			apiUrl = "ice-app/api/bulk/%s/start";
		}
		return apiUrl;
	}
}