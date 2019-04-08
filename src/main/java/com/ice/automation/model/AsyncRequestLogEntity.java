package com.ice.automation.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;


@Entity
@Component
@Table(name = "async_request_log")
public class AsyncRequestLogEntity implements Serializable {
    private static final long serialVersionUID = -480443321972154538L;

    public enum EventType {
        BILLING,
        PROVISION
    }

    @Id
    @GeneratedValue
    @Column(name = "pk_external_api_request_log_id")
    private Long id;

    @Column(nullable = false, updatable = false)
    private String msisdn;

    @Column(name = "event_time", nullable = false, updatable = false)
    private Timestamp eventTime;

    @Column(name = "event_id", nullable = false, updatable = false)
    private String eventId;

    @Column(name = "event_type", nullable = false, updatable = false)
    private String eventType;

    @Column(name = "parameter_1", updatable = false)
    private String parameter1;

    @Column(name = "parameter_2", updatable = false)
    private String parameter2;

    public AsyncRequestLogEntity() {
    }

    public AsyncRequestLogEntity(String msisdn, Timestamp eventTime, String eventId, String eventType) {
        this.msisdn = msisdn;
        this.eventTime = eventTime;
        this.eventId = eventId;
        this.eventType = eventType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsyncRequestLogEntity that = (AsyncRequestLogEntity) o;
        return Objects.equals(getMsisdn(), that.getMsisdn()) &&
                Objects.equals(getEventTime(), that.getEventTime()) &&
                Objects.equals(getEventId(), that.getEventId()) &&
                Objects.equals(getEventType(), that.getEventType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMsisdn(), getEventTime(), getEventId(), getEventType());
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }
}
