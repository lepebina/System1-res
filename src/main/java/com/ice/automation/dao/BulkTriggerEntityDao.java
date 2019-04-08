package com.ice.automation.dao;

import com.ice.automation.model.bulk.BulkTriggerEntity;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface BulkTriggerEntityDao {

    List<BulkTriggerEntity> getAllToSchedule();

    BulkTriggerEntity getBulkById(long bulkId);

    void deleteTrigger(String triggerName);
}
