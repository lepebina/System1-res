package com.ice.automation.model.subscription;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity  @Component
@Table(name = "subscription_log")
public class SubscriptionLogEntity implements Serializable {
    private static final long serialVersionUID = -9139239007332598258L;

    public enum SubscriptionRequestType {
        SUBSCRIBE,
        UNSUBSCRIBE,
        CHARGE
    }

    @Id
    @GeneratedValue
    @Column(name = "pk_subscription_log_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "event_time", nullable = false, updatable = false)
    private Timestamp eventTime;

    @Column(name = "event_id", nullable = false, updatable = false)
    private String eventId;

    @Column(name = "subscription_id", nullable = false, updatable = false)
    private Integer subscriptionId;

    @Column(nullable = false, updatable = false)
    private String msisdn;

    @Column(name = "request_type", nullable = false, updatable = false)
    private String requestType;

    @Column(name = "charge_point", updatable = false)
    private String chargePoint;

    SubscriptionLogEntity() {
    }

    public SubscriptionLogEntity(Timestamp eventTime, String eventId, Integer subscriptionId, String msisdn, String requestType, String chargePoint) {
        this.eventTime = eventTime;
        this.eventId = eventId;
        this.subscriptionId = subscriptionId;
        this.msisdn = msisdn;
        this.requestType = requestType;
        this.chargePoint = chargePoint;
    }

    public SubscriptionLogEntity(Timestamp eventTime, String eventId, Integer subscriptionId, String msisdn, SubscriptionRequestType requestType) {
        this.eventTime = eventTime;
        this.eventId = eventId;
        this.subscriptionId = subscriptionId;
        this.msisdn = msisdn;
        this.requestType = requestType.name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getEventTime() {
        return eventTime;
    }

    public void setEventTime(Timestamp eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getChargePoint() {
        return chargePoint;
    }

    public void setChargePoint(String chargePoint) {
        this.chargePoint = chargePoint;
    }
}
