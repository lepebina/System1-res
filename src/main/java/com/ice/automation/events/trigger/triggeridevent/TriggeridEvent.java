package com.ice.automation.events.trigger.triggeridevent;

import org.springframework.stereotype.Component;

@Component
public class TriggeridEvent {
	String apiUrl;
	String jsonObject = "{\n" +
			"  \"id\": %s,\n" +
			"  \"name\": \"%s'\",\n" +
			"  \"cron\": \"%s\"\n" +
			"}\n";
	String id;
	String name;
	String cron;


	public String getJsonObject() {
		return String.format(jsonObject,this.getId(),this.getName(),this.getCron());
	}

	public void setJsonObject(String jsonObject) {
		this.jsonObject = jsonObject;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getApiUrl() {
		if (apiUrl == null) {
			apiUrl = "ice-app/api/trigger";
		}
		return apiUrl;
	}
}