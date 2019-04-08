package com.ice.automation.dao;

import com.ice.automation.model.text.TextScheduleInstanceEntity;

import java.util.Date;
import java.util.List;


public interface TextScheduleDao {

    TextScheduleInstanceEntity getTextScheduleByIdAndOrder(long textScheduleId, int order);

    List<TextScheduleInstanceEntity> getAllForDay(Date day);

    TextScheduleInstanceEntity getForDay(String textKey, Date day);

    TextScheduleInstanceEntity getForOrder(String textKey, int order);
}
