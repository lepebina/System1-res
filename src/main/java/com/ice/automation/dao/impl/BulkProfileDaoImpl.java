package com.ice.automation.dao.impl;

import com.ice.automation.model.bulk.BulkProfileEntity;
import com.ice.automation.dao.BulkProfileDao;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("bulkProfileDao")
public class BulkProfileDaoImpl extends GenericEntityDaoImpl<BulkProfileEntity> implements BulkProfileDao {

    public BulkProfileEntity getProfileBulk(String msisdn, long bulkId) {
        return (BulkProfileEntity) sessionFactory.getCurrentSession()
                                                 .createCriteria(BulkProfileEntity.class)
                                                 .add(Restrictions.eq("profileKey", msisdn))
                                           .add(Restrictions.eq("bulkId", bulkId))
                                           .uniqueResult();
    }
}
