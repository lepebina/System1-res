package com.ice.automation.dao.impl;

import com.ice.automation.model.subscription.SubscriptionEntity;
import com.ice.automation.dao.SubscriptionEntityDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("subscriptionEntityDao")
public class SubscriptionEntityDaoImpl extends GenericEntityDaoImpl<SubscriptionEntity> implements SubscriptionEntityDao {

    public SubscriptionEntity getSubscriptionByName(String name) {
        return (SubscriptionEntity) sessionFactory.getCurrentSession().createQuery("select s from SubscriptionEntity s where s.name=:name")
                                                  .setString("name", name).uniqueResult();
    }

    public SubscriptionEntity getSubscriptionById(long subscriptionId) {
        return (SubscriptionEntity) sessionFactory.getCurrentSession().createQuery("select s from SubscriptionEntity s where s.id=:subscriptionId")
                                                  .setLong("subscriptionId", subscriptionId).uniqueResult();
    }

    @Transactional
    public void deleteSubscription(String subscriptionName) {
        String hql = String.format("delete from SubscriptionEntity where name=%s",subscriptionName);
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.executeUpdate();
    }
}
