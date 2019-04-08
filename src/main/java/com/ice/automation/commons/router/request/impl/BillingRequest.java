package com.ice.automation.commons.router.request.impl;

import com.ice.automation.commons.router.Channel;
import com.ice.automation.commons.router.Message;
import com.ice.automation.commons.router.request.Request;

import java.sql.Timestamp;


public class BillingRequest extends Request {

    private long subscriptionId;
    private double chargePoint;

    private String serviceName;

    private Message originalRequest;

    public BillingRequest(String requestId, String customerKey, Timestamp requestDate, long subscriptionId, double chargePoint, String serviceName,
            Message originalRequest) {
        super(requestId, Channel.SUB, customerKey, requestDate);
        this.subscriptionId = subscriptionId;
        this.chargePoint = chargePoint;
        this.serviceName = serviceName;
        this.originalRequest = originalRequest;
    }

    public long getSubscriptionId() {
        return subscriptionId;
    }

    public double getChargePoint() {
        return chargePoint;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Message getOriginalRequest() {
        return originalRequest;
    }

    @Override
    public String getLanguageCode() {
        throw new IllegalArgumentException("not implemented");
    }
}
