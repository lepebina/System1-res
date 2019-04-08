package com.ice.automation.dao;

import com.ice.automation.model.CustomerEntity;


public interface CustomerDao {

    CustomerEntity getProfileByMsisdnWithWriteLock(String key);

    CustomerEntity getProfileByMsisdnWithoutLock(String msisdn);
}
