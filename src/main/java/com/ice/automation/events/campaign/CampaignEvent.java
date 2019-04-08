package com.ice.automation.events.campaign;


import org.springframework.stereotype.Component;

@Component
public class CampaignEvent {
	String apiUrl;
	String campaignKey;
	String startDate;
	String endDate;
	String defaultLangCode;

	public String getJsonObject() {

		return jsonObject = String.format(this.jsonObject,this.getCampaignKey(),this.getStartDate(),this.getEndDate(),this.getDefaultLangCode());
	}


	String jsonObject = "{\n" +
			"  \"campaignKey\":\"%s\",\n" +
			"  \"startDate\":\"%s\",\n" +
			"  \"endDate\":\"%s\",\n" +
			"  \"defaultLangCode\":\"%s\"\n" +
			"}";

	public void setCampaignKey(String campaignKey) {
		this.campaignKey = campaignKey;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setDefaultLangCode(String defaultLangCode) {
		this.defaultLangCode = defaultLangCode;
	}

	public String getCampaignKey() {
		return campaignKey;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getDefaultLangCode() {
		return defaultLangCode;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getApiUrl() {
		if (apiUrl == null) {
			apiUrl = "ice-app/api/config/campaign";
		}
		return apiUrl;
	}

	public void setJsonObject() {
		this.jsonObject = "{\n" +
				"  \"campaignKey\":\"%s\",\n" +
				"  \"startDate\":\"%s\",\n" +
				"  \"endDate\":\"%s\",\n" +
				"  \"defaultLangCode\":\"%s\"\n" +
				"}";
	}
}