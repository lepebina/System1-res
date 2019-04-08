package com.ice.automation.model.subscription;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity @Component
@Table(name = "subscription_profile")
public class SubscriptionProfileEntity implements Serializable {
    private static final long serialVersionUID = -8378867029794561758L;

    public enum SubscriptionStatus {
        SUBSCRIBED,
        UNSUBSCRIBED,
        PARKED
    }

    @Id
    @GeneratedValue
    @Column(name = "pk_subscription_profile_id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String msisdn;

    @Column(name = "subscription_id", nullable = false, updatable = false)
    private Integer subscriptionId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;

    @Column(name = "first_optin_time", updatable = false)
    private Timestamp firstOptinTime;

    @Column(name = "last_optin_time")
    private Timestamp lastOptinTime;

    @Column(name = "first_optout_time")
    private Timestamp firstOptOutTime;

    @Column(name = "last_optout_time")
    private Timestamp lastOptOutTime;

    @Column(name = "first_charge_date")
    private Timestamp firstChargeTime;

    @Column(name = "last_charge_date")
    private Timestamp lastChargeTime;

    @Column(name = "total_content_deliveries")
    private int totalContentDeliveries;

    @Column(name = "last_content_time")
    private Timestamp lastContentTime;

    public void addContentDelivery() {
        this.totalContentDeliveries++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public void setStatus(SubscriptionStatus status) {
        this.status = status;
    }

    public Timestamp getFirstOptinTime() {
        return firstOptinTime;
    }

    public void setFirstOptinTime(Timestamp firstOptinTime) {
        this.firstOptinTime = firstOptinTime;
    }

    public Timestamp getLastOptinTime() {
        return lastOptinTime;
    }

    public void setLastOptinTime(Timestamp lastOptinTime) {
        this.lastOptinTime = lastOptinTime;
    }

    public Timestamp getFirstOptOutTime() {
        return firstOptOutTime;
    }

    public void setFirstOptOutTime(Timestamp firstOptOutTime) {
        this.firstOptOutTime = firstOptOutTime;
    }

    public Timestamp getLastOptOutTime() {
        return lastOptOutTime;
    }

    public void setLastOptOutTime(Timestamp lastOptOutTime) {
        this.lastOptOutTime = lastOptOutTime;
    }

    public Timestamp getFirstChargeTime() {
        return firstChargeTime;
    }

    public void setFirstChargeTime(Timestamp firstChargeTime) {
        this.firstChargeTime = firstChargeTime;
    }

    public Timestamp getLastChargeTime() {
        return lastChargeTime;
    }

    public void setLastChargeTime(Timestamp lastChargeTime) {
        this.lastChargeTime = lastChargeTime;
    }

    public int getTotalContentDeliveries() {
        return totalContentDeliveries;
    }

    public void setTotalContentDeliveries(int totalContentDeliveries) {
        this.totalContentDeliveries = totalContentDeliveries;
    }

    public Timestamp getLastContentTime() {
        return lastContentTime;
    }

    public void setLastContentTime(Timestamp lastContentTime) {
        this.lastContentTime = lastContentTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((subscriptionId == null) ? 0 : subscriptionId.hashCode());
        result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null) { return false; }
        if (!(obj instanceof SubscriptionProfileEntity)) { return false; }
        SubscriptionProfileEntity other = (SubscriptionProfileEntity) obj;
        if (id == null) {
            if (other.id != null) { return false; }
        } else if (!id.equals(other.id)) { return false; }
        if (subscriptionId == null) {
            if (other.subscriptionId != null) { return false; }
        } else if (!subscriptionId.equals(other.subscriptionId)) { return false; }
        if (msisdn == null) {
            if (other.msisdn != null) { return false; }
        } else if (!msisdn.equals(other.msisdn)) { return false; }
        return true;
    }
}
