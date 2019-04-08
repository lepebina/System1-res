package com.ice.automation.dao;


import com.ice.automation.model.blacklist.BlacklistedCustomerEntity;

public interface BlacklistDao extends GenericEntityDao<BlacklistedCustomerEntity> {

    BlacklistedCustomerEntity getBlacklistedCustomer(String msisdn);

    void removeBlacklistedCustomer(String msisdn);
}
