package com.ice.automation.dao.impl;

import com.ice.automation.model.blackhours.BlackHourPeriodEntity;
import com.ice.automation.dao.BlackHoursDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SuppressWarnings("unchecked")
@Repository("blackHoursDao")
public class BlackHoursDaoImpl extends GenericEntityDaoImpl<BlackHourPeriodEntity> implements BlackHoursDao {

    @Transactional(readOnly = true)
    public List<BlackHourPeriodEntity> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(BlackHourPeriodEntity.class).list();
    }
}
