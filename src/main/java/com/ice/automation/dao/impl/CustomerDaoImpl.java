package com.ice.automation.dao.impl;

import com.ice.automation.model.CustomerEntity;
import com.ice.automation.dao.CustomerDao;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("customerDao")
public class CustomerDaoImpl extends GenericEntityDaoImpl<CustomerEntity> implements CustomerDao {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final int DEFAULT_RETRIES_INTERVAL_MILLIES = 500;
    private static final int DEFAULT_RETRIES = 5;

    public CustomerEntity getProfileByMsisdnWithWriteLock(String key) {

        CustomerEntity customerEntity = new CustomerEntity();
        int numberOfRetries = 0;
        boolean isProfileLocked;

        //        Query query = sessionFactory.getCurrentSession().getNamedQuery("getProfileByMsisdnWithWriteLock").setParameter("msisdn", key);
        //
        //        do {
        //            try {
        //                customer = (Customer) query.uniqueResult();
        //                isProfileLocked = false;
        //            } catch (LockAcquisitionException ex) {
        //                numberOfRetries++;
        //                isProfileLocked = true;
        //                logger.warn("The acquisition of profile of " + key + " is locked by another process and will be Retried in " + DEFAULT_RETRIES_INTERVAL_MILLIES + " millies");
        //                try {
        //                    TimeUnit.MILLISECONDS.sleep(DEFAULT_RETRIES_INTERVAL_MILLIES);
        //                } catch (InterruptedException e) {
        //                    throw new IllegalStateException("The thread sleep for getting the user profile can not be notified");
        //                }
        //            }
        //        } while (isProfileLocked && numberOfRetries < DEFAULT_RETRIES);
        //
        //        if (isProfileLocked) {
        //            throw new ContactLockedException("The profile with msisdn: " + key + " could not be retrieved as it was locked by another process running in parallel");
        //        }
        //
        //        return customer;

        customerEntity.setMsisdn(key);
        return customerEntity;
    }

    /**
     * Fetches the profile
     *
     * @param msisdn the msisdn
     *
     * @return the profile or null if not found
     */
    public CustomerEntity getProfileByMsisdnWithoutLock(String msisdn) {
        return (CustomerEntity) sessionFactory.getCurrentSession().createCriteria(CustomerEntity.class)
                                        .add(Restrictions.eq("msisdn", msisdn))
                                        .uniqueResult();
    }
}
