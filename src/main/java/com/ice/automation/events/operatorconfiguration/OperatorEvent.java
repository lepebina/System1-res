package com.ice.automation.events.operatorconfiguration;


import org.springframework.stereotype.Component;

@Component
public class OperatorEvent {
	String apiUrl;
	String asd;
	String operatorName;
	String countryCode;
	String shortcodes;

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getShortcodes() {
		return shortcodes;
	}

	public void setShortcodes(String shortcodes) {
		this.shortcodes = shortcodes;
	}

	public String getCostWeight() {
		return costWeight;
	}

	public void setCostWeight(String costWeight) {
		this.costWeight = costWeight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	String costWeight;
	String type;
	String msisdnPrefix;
	String msisdnLengthWithoutPrefix;

	public String getMsisdnPrefix() {
		return msisdnPrefix;
	}

	public void setMsisdnPrefix(String msisdnPrefix) {
		this.msisdnPrefix = msisdnPrefix;
	}

	public String getMsisdnLengthWithoutPrefix() {
		return msisdnLengthWithoutPrefix;
	}

	public void setMsisdnLengthWithoutPrefix(String msisdnLengthWithoutPrefix) {
		this.msisdnLengthWithoutPrefix = msisdnLengthWithoutPrefix;
	}

	String jsonObject = "{\n" +
			"  \"name\": \"%s\",\n" +
			"  \"countryCode\" : \"%s\",\n" +
			"  \"msisdnPrefix\": \"%s\",\n" +
			"  \"msisdnLengthWithoutPrefix\": \"%s\",\n"+
			"  \"shortcodes\": [\n" +
			"    {\n" +
			"      \"shortcode\": \"%s\",\n" +
			"      \"costWeight\": %s,\n" +
			"      \"type\": \"%s\"\n" +
			"    }\n" +
			"  ]\n" +
			"}\n";

	public String getJsonObject() {
		return String.format(this.jsonObject,this.getOperatorName(),this.getCountryCode(),this.getMsisdnPrefix(),this.getMsisdnLengthWithoutPrefix(),this.getShortcodes(),this.getCostWeight(),this.getType());
	}

	public void setJsonObject(String jsonObject) {
		this.jsonObject = jsonObject;
	}

	public void setAsd(String asd) {
		this.asd = asd;
	}

	public String getAsd() {
		return asd;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getApiUrl() {
		if (apiUrl == null) {
			apiUrl = "ice-app/api/config/operator";
		}
		return apiUrl;
	}
}