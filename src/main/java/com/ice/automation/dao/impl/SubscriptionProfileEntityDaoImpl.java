package com.ice.automation.dao.impl;

import com.ice.automation.model.subscription.SubscriptionProfileEntity;
import com.ice.automation.dao.SubscriptionProfileEntityDao;
import org.springframework.stereotype.Repository;


@Repository("subscriptionProfileEntityDao")
public class SubscriptionProfileEntityDaoImpl extends GenericEntityDaoImpl<SubscriptionProfileEntity> implements SubscriptionProfileEntityDao {

    public SubscriptionProfileEntity getProfile(String msisdn, long subscriptionId) {
        return (SubscriptionProfileEntity) sessionFactory.getCurrentSession().createQuery(
                "select p from SubscriptionProfileEntity p where p.subscriptionId=:subscriptionId and p.msisdn=:msisdn")
                                                         .setLong("subscriptionId", subscriptionId)
                                                         .setString("msisdn", msisdn)
                                                         .uniqueResult();
    }
}
