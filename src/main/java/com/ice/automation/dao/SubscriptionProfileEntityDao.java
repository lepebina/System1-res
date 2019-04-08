package com.ice.automation.dao;

import com.ice.automation.model.subscription.SubscriptionProfileEntity;


public interface SubscriptionProfileEntityDao {

    SubscriptionProfileEntity getProfile(String msisdn, long subscriptionId);
}
