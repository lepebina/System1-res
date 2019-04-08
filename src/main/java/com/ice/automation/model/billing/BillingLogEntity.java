package com.ice.automation.model.billing;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity  @Component
@Table(name = "billing_log")
public class BillingLogEntity {

    public enum EventType {
        CHARGE_REQUEST,
        CHARGE_RESPONSE
    }

    @Id
    @Column(name = "pk_billing_log")
    private long id;
    @Column
    private String msisdn;
    @Column(name = "event_time")
    private Timestamp eventTime;
    @Column(name = "event_id")
    private String eventId;
    @Column(name = "event_type")
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    @Column(name = "cost_weight")
    private Double costWeight;
    @Column(name = "fk_subscription_Id")
    private long subscriptionId;

    BillingLogEntity() {
    }

    public BillingLogEntity(String msisdn, Timestamp eventTime, String eventId, EventType eventType, Double costWeight, long subscriptionId) {
        this.msisdn = msisdn;
        this.eventTime = eventTime;
        this.eventId = eventId;
        this.eventType = eventType;
        this.costWeight = costWeight;
        this.subscriptionId = subscriptionId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
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

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Double getCostWeight() {
        return costWeight;
    }

    public void setCostWeight(Double costWeight) {
        this.costWeight = costWeight;
    }

    public long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}
