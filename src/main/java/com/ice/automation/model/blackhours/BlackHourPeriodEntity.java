package com.ice.automation.model.blackhours;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity  @Component
@Table(name = "cfg_black_hours")
public class BlackHourPeriodEntity {

    @Id
    @GeneratedValue
    @Column(name = "pk_black_hours")
    private long id;
    @Column(name = "start_day_of_week")
    private int startDayOfWeek;
    @Column(name = "end_day_of_week")
    private int endDayOfWeek;
    @Column(name = "start_hour_of_day")
    private int startHourOfDay;
    @Column(name = "end_hour_of_day")
    private int endHourOfDay;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStartDayOfWeek() {
        return startDayOfWeek;
    }

    public void setStartDayOfWeek(int startDayOfWeek) {
        this.startDayOfWeek = startDayOfWeek;
    }

    public int getEndDayOfWeek() {
        return endDayOfWeek;
    }

    public void setEndDayOfWeek(int endDayOfWeek) {
        this.endDayOfWeek = endDayOfWeek;
    }

    public int getStartHourOfDay() {
        return startHourOfDay;
    }

    public void setStartHourOfDay(int startHourOfDay) {
        this.startHourOfDay = startHourOfDay;
    }

    public int getEndHourOfDay() {
        return endHourOfDay;
    }

    public void setEndHourOfDay(int endHourOfDay) {
        this.endHourOfDay = endHourOfDay;
    }
}
