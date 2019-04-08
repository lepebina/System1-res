package com.ice.automation.dao;

import com.ice.automation.model.bulk.BulkProfileEntity;
import org.springframework.stereotype.Repository;

@Repository("bulkProfileDao")
public interface BulkProfileDao {

    BulkProfileEntity getProfileBulk(String msisdn, long bulkId);
}
