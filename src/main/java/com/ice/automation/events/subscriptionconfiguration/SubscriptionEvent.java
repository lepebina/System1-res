package com.ice.automation.events.subscriptionconfiguration;

import org.springframework.stereotype.Component;

@Component
public class SubscriptionEvent {
	String apiUrl;

	/*timestamp 01/01/2015 00:00:00*/
	String jsonObject= "{\n" +
			"  \"name\": \"%s\",\n" +
			"  \"startDate\": \"%s\",\n" +
			"  \"endDate\": \"%s\",\n" +
			"  \"freePeriodDays\": %s,\n" +
			"  \"contentOnOptin\": %s,\n" +
			"  \"costWeight\": %s,\n" +
			"  \"enabled\": %s\n" +
			"}\n";
	private String name;
	private String startDate;
	private String endDate;
	private String freePeriodDays;
	private String contentOnOptin;
	private String costWeight;
	private String subscriptionId;
	private String apiEditUrl;

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	private String enabled;

	public void setName(String name) {
		this.name = name;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setFreePeriodDays(String freePeriodDays) {
		this.freePeriodDays = freePeriodDays;
	}

	public void setContentOnOptin(String contentOnOptin) {
		this.contentOnOptin = contentOnOptin;
	}

	public void setCostWeight(String costWeight) {
		this.costWeight = costWeight;
	}

	public void setJsonObject(String jsonObject) {
		this.jsonObject = jsonObject;
	}

	public String getJsonObject() {
		return String.format(this.jsonObject, this.getName(), this.getStartDate(), this.getEndDate(), this.getFreePeriodDays(), this.getContentOnOptin(), this.getCostWeight(),this.getEnabled());
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getApiUrl() {
		if (apiUrl == null) {
			apiUrl = "ice-app/api/subscription";
		}
		return apiUrl;
	}

	public void setApiEditUrl(String apiEditUrl) {
		this.apiEditUrl = apiEditUrl;
	}

	public String getApiEditUrl() {
		if (apiEditUrl == null) {
			apiEditUrl = String.format("ice-app/api/subscription/%s",this.getSubscriptionId());
		}
		return apiEditUrl;
	}

	public String getName() {
		return name;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getFreePeriodDays() {
		return freePeriodDays;
	}

	public String getContentOnOptin() {
		return contentOnOptin;
	}

	public String getCostWeight() {
		return costWeight;
	}
}