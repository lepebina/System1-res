package com.ice.automation.dao.impl;

import com.ice.automation.model.activity.ActivityEntity;
import com.ice.automation.dao.ActivityEntityDao;
import org.springframework.stereotype.Repository;


@Repository("activityEntityDao")
public class ActivityEntityDaoImpl extends GenericEntityDaoImpl<ActivityEntity> implements ActivityEntityDao {

    public ActivityEntity getActivityById(long activityId) {
        return (ActivityEntity) sessionFactory.getCurrentSession()
                                              .createSQLQuery("select a from ActivityEntity a where a.id=:activityId").setLong("activityId", activityId).uniqueResult();
    }
}
