package com.ice.automation.dao;

import com.ice.automation.model.blackhours.BlackHourPeriodEntity;

import java.util.List;


public interface BlackHoursDao {

    List<BlackHourPeriodEntity> findAll();
}
