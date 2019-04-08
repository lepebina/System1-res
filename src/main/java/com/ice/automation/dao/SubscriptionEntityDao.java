package com.ice.automation.dao;

import com.ice.automation.model.subscription.SubscriptionEntity;


public interface SubscriptionEntityDao extends GenericEntityDao<SubscriptionEntity> {

    SubscriptionEntity getSubscriptionByName(String name);

    SubscriptionEntity getSubscriptionById(long subscriptionId);
}
