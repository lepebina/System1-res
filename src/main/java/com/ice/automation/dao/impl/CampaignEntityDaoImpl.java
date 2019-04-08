package com.ice.automation.dao.impl;

import com.ice.automation.model.cfg.CampaignEntity;
import com.ice.automation.dao.CampaignEntityDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("campaignEntityDao")
public class CampaignEntityDaoImpl extends GenericEntityDaoImpl<CampaignEntity> implements CampaignEntityDao {

    public CampaignEntity getCampaignConfiguration() {
        return (CampaignEntity) sessionFactory.getCurrentSession().createCriteria(CampaignEntity.class).uniqueResult();
    }

    @Transactional
    public void deleteCampaigns() {
            String hql = "delete from CampaignEntity";
            Query query = sessionFactory.getCurrentSession().createQuery(hql);
            query.executeUpdate();
    }
}
