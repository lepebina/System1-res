package com.ice.automation.dao.impl;

import com.ice.automation.model.smartfield.SmartfieldEntity;
import com.ice.automation.dao.SmartfieldEntityDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository("smartfieldEntityDao")
public class SmartfieldEntityDaoImpl extends GenericEntityDaoImpl<SmartfieldEntity> implements SmartfieldEntityDao {

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<SmartfieldEntity> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(SmartfieldEntity.class).list();
    }
}
