package com.ice.automation.dao.impl;

import com.ice.automation.model.cfg.LanguageEntity;
import com.ice.automation.dao.LanguageEntityDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository("languageEntityDao")
public class LanguageEntityDaoImpl extends GenericEntityDaoImpl<LanguageEntity> implements LanguageEntityDao {

    public List<LanguageEntity> getAllLanguages() {
        return sessionFactory.getCurrentSession().createCriteria(LanguageEntity.class).list();
    }

    public LanguageEntity getLanguage(String isoCode) {
        return (LanguageEntity) sessionFactory.getCurrentSession().createQuery("select l from LanguageEntity l where l.isoCode=:isoCode").setString("isoCode",
                                                                                                                                                    isoCode).uniqueResult();
    }
}
