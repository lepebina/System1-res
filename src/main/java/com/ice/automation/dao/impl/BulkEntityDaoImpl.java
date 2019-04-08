package com.ice.automation.dao.impl;

import com.ice.automation.dao.BulkEntityDao;
import com.ice.automation.model.activity.ActivityEntity;
import com.ice.automation.model.bulk.BulkEntity;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Repository("bulkEntityDaoI")
public class BulkEntityDaoImpl extends GenericEntityDaoImpl<BulkEntity> implements BulkEntityDao {

    @SuppressWarnings("unchecked")
    public List<BulkEntity> getAllToSchedule() {
        return sessionFactory.getCurrentSession()
                             .createCriteria(BulkEntity.class, "b")
                             .add(Restrictions.ge("b.startDate", new Date()))
                             .list();
    }

    public BulkEntity getBulkById(long bulkId) {
        return (BulkEntity) sessionFactory.getCurrentSession()
                                          .createCriteria(BulkEntity.class, "b")
                                          .add(Restrictions.eq("b.id", bulkId))
                                          .uniqueResult();
    }

    @Transactional
    public void deleteBulk(String bulkName) {
        String hql = String.format("delete from BulkEntity where name=%s",bulkName);
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.executeUpdate();
    }

}
