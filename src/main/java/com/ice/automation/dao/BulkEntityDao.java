package com.ice.automation.dao;

import com.ice.automation.model.bulk.BulkEntity;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface BulkEntityDao {

    List<BulkEntity> getAllToSchedule();

    BulkEntity getBulkById(long bulkId);

    void deleteBulk(String bulkName);
}
