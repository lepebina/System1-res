package com.ice.automation.dao.impl;

import com.ice.automation.dao.CampaignEntityDao;
import com.ice.automation.dao.OperatorEntityDao;
import com.ice.automation.model.cfg.CampaignEntity;
import com.ice.automation.model.cfg.OperatorEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("operatorEntityDao")
public class OperatorEntityDaoImpl extends GenericEntityDaoImpl<OperatorEntity> implements OperatorEntityDao {

    @Transactional
    public void deleteOperators() {
            String hql = "delete from OperatorEntity ";
            Query query = sessionFactory.getCurrentSession().createQuery(hql);
            query.executeUpdate();
    }

    @Transactional
    public void deleteShortcodes() {
        String hql = "delete from ShortcodeEntity";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.executeUpdate();
    }
}
