package com.ice.automation.dao.impl;

import com.ice.automation.dao.AchievementEntityDao;
import com.ice.automation.model.AchievementEntity;
import com.ice.automation.model.activity.ActivityEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("achievementEntityDao")
public class AchievementEntityDaoImpl extends GenericEntityDaoImpl<ActivityEntity> implements AchievementEntityDao {


    @Transactional
    public void deleteAchievement(String achievementName) {
        String hql = String.format("delete from AchievementEntity where name=%s",achievementName);
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.executeUpdate();
    }

    @Override
    public AchievementEntity getAchievementById(long activityId) {
        return (AchievementEntity) sessionFactory.getCurrentSession()
                .createSQLQuery("select a from AchievementEntity a where a.id=:activityId").setLong("activityId", activityId).uniqueResult();    }
}
