package com.ice.automation.dao.impl;

import com.ice.automation.dao.BulkTriggerEntityDao;
import com.ice.automation.model.bulk.BulkTriggerEntity;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Repository("bulkTriggerEntityDaoI")
public class BulkTriggerEntityDaoImpl extends GenericEntityDaoImpl<BulkTriggerEntity> implements BulkTriggerEntityDao {

    @SuppressWarnings("unchecked")
    public List<BulkTriggerEntity> getAllToSchedule() {
        return sessionFactory.getCurrentSession()
                             .createCriteria(BulkTriggerEntity.class, "b")
                             .add(Restrictions.ge("b.startDate", new Date()))
                             .list();
    }

    public BulkTriggerEntity getBulkById(long bulkId) {
        return (BulkTriggerEntity) sessionFactory.getCurrentSession()
                                          .createCriteria(BulkTriggerEntity.class, "b")
                                          .add(Restrictions.eq("b.id", bulkId))
                                          .uniqueResult();
    }

    @Transactional
    public void deleteTrigger(String triggerName) {
        String hql = String.format("delete fom BulkTriggerEntity where name=%s",triggerName);
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.executeUpdate();
    }

}
