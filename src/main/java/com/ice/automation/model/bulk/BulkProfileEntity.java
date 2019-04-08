package com.ice.automation.model.bulk;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;


@Entity  @Component
@Table(name = "bulk_profile")
public class BulkProfileEntity {

    @Id
    @GeneratedValue
    @Column(name = "pk_bulk_profile")
    private Long id;

    @Column(name = "profile_key")
    private String profileKey;
    @Column(name = "fk_bulk_id")
    private long bulkId;

    @Column(name = "last_received_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastOccurredDate;

    @Column(name = "bulks_today")
    private long bulksReceivedToday;

    public Date getLastOccurredDate() {
        return lastOccurredDate;
    }

    public void setLastOccurredDate(Date lastOccurredDate) {
        this.lastOccurredDate = lastOccurredDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfileKey() {
        return profileKey;
    }

    public void setProfileKey(String profileKey) {
        this.profileKey = profileKey;
    }

    public long getBulkId() {
        return bulkId;
    }

    public void setBulkId(long bulkId) {
        this.bulkId = bulkId;
    }

    public long getBulksReceivedToday() {
        return bulksReceivedToday;
    }

    public void setBulksReceivedToday(long bulksReceivedToday) {
        this.bulksReceivedToday = bulksReceivedToday;
    }
}
