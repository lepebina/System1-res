package com.ice.automation.dao;

import com.ice.automation.model.text.pool.PoolScheduleEntity;
import com.ice.automation.model.text.pool.QuestionEntity;


public interface PoolScheduleDao extends GenericEntityDao<PoolScheduleEntity> {

    PoolScheduleEntity getPoolScheduleById(long poolScheduleId);

    QuestionEntity getFirstQuestion(long pollScheduleInstanceId);
}
