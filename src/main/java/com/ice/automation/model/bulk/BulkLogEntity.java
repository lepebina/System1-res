package com.ice.automation.model.bulk;


import com.ice.automation.commons.bulk.BulkStatus;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity  @Component
@Table(name = "bulk_log")
public class BulkLogEntity implements Serializable {

    @Id
    @Column(name = "pk_bulk_log")
    private long id;
    @Column(name = "fk_bulk_id")
    private long fkTeaserId;
    @Column(name = "target")
    private int profilesToTease = 0;
    @Column(name = "actual")
    private int profilesTeased = 0;
    @Column(name = "start_time")
    private Timestamp startTime;
    @Column(name = "end_time")
    private Timestamp endTime;
    @Column(name = "no_of_threads")
    private int runningThreads;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BulkStatus status;

    public BulkLogEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long theId) {
        id = theId;
    }

    public long getFkTeaserId() {
        return fkTeaserId;
    }

    public void setFkTeaserId(long theFkTeaserId) {
        fkTeaserId = theFkTeaserId;
    }

    public int getProfilesToTease() {
        return profilesToTease;
    }

    public void setProfilesToTease(int theProfilesToTease) {
        profilesToTease = theProfilesToTease;
    }

    public int getProfilesTeased() {
        return profilesTeased;
    }

    public void setProfilesTeased(int theProfilesTeased) {
        profilesTeased = theProfilesTeased;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp theStartTime) {
        startTime = theStartTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp theEndTime) {
        endTime = theEndTime;
    }

    public int getRunningThreads() {
        return runningThreads;
    }

    public void setRunningThreads(int theRunningThreads) {
        runningThreads = theRunningThreads;
    }

    public BulkStatus getStatus() {
        return status;
    }

    public void setStatus(BulkStatus status) {
        this.status = status;
    }
}
