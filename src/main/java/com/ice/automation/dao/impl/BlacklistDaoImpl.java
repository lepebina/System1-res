package com.ice.automation.dao.impl;

import com.ice.automation.dao.BlacklistDao;
import com.ice.automation.model.blacklist.BlacklistedCustomerEntity;
import org.springframework.stereotype.Repository;



@Repository
public class BlacklistDaoImpl extends GenericEntityDaoImpl<BlacklistedCustomerEntity> implements BlacklistDao {

    public BlacklistedCustomerEntity getBlacklistedCustomer(String msisdn) {
        return (BlacklistedCustomerEntity) sessionFactory.getCurrentSession().createQuery
                ("select b from BlacklistedCustomerEntity b where b.msisdn=:msisdn").setParameter("msisdn", msisdn).uniqueResult();
    }

    public void removeBlacklistedCustomer(String msisdn) {
        sessionFactory.getCurrentSession().createSQLQuery("delete from blacklist where msisdn=:msisdn").setParameter("msisdn", msisdn).executeUpdate();
    }
}
