package com.ice.automation.events.billing;

import org.springframework.stereotype.Component;

@Component
public class BillingEvent {
	String apiUrl;
	String chargePoint;
    String msisdn;
    String subId;
    String eventId;
    String billingResult;

	public void setChargePoint(String chargePoint) {
		this.chargePoint = chargePoint;
	}

	public String getChargePoint() {
		return chargePoint;
	}

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getBillingResult() {
        return billingResult;
    }

    public void setBillingResult(String billingResult) {
        this.billingResult = billingResult;
    }

    public String getApiUrl() {
		if (apiUrl == null) {
			apiUrl = "ice-app/api/billing/";
		}
		return apiUrl;
	}
}