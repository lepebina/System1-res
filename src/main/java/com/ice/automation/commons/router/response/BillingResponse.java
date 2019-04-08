package com.ice.automation.commons.router.response;

import com.ice.automation.commons.router.Message;

import java.sql.Timestamp;


public class BillingResponse extends Response {

    private String msisdn;
    private long subscriptionId;
    private String chargePoint;

    private String serviceName;

    private Message originalMo;

    public BillingResponse(String responseId, Timestamp responseTime, String msisdn, long subscriptionId, String chargePoint, String serviceName, Message originalMo) {
        super(responseId, responseTime);
        this.msisdn = msisdn;
        this.subscriptionId = subscriptionId;
        this.chargePoint = chargePoint;
        this.serviceName = serviceName;
        this.originalMo = originalMo;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public long getSubscriptionId() {
        return subscriptionId;
    }

    public String getChargePoint() {
        return chargePoint;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Message getOriginalMo() {
        return originalMo;
    }
}
