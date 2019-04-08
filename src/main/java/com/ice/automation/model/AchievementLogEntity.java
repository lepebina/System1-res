package com.ice.automation.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity @Component
@Table(name = "achievements_log")
public class AchievementLogEntity {

    @Id
    @GeneratedValue
    @Column(name = "pk_achievements_log", nullable = false, updatable = false)
    private int id;
    @Column(nullable = false, updatable = false)
    private String msisdn;
    @OneToOne(optional = false)
    @JoinColumn(name = "fk_achievement_id")
    private AchievementEntity achievementEntity;
    @Column(name = "obtained_time", nullable = false, updatable = false)
    private Timestamp obtainedTime;
    @Column(name = "awarded_time")
    private Timestamp awardedTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public AchievementEntity getAchievementEntity() {
        return achievementEntity;
    }

    public void setAchievementEntity(AchievementEntity achievementEntity) {
        this.achievementEntity = achievementEntity;
    }

    public Timestamp getObtainedTime() {
        return obtainedTime;
    }

    public void setObtainedTime(Timestamp obtainedTime) {
        this.obtainedTime = obtainedTime;
    }

    public Timestamp getAwardedTime() {
        return awardedTime;
    }

    public void setAwardedTime(Timestamp awardedTime) {
        this.awardedTime = awardedTime;
    }
}
