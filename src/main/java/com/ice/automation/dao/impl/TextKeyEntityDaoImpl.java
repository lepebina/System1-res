package com.ice.automation.dao.impl;

import com.ice.automation.cache.SystemAttributes;
import com.ice.automation.model.text.TextContentEntity;
import com.ice.automation.model.text.TextKeyEntity;
import com.ice.automation.dao.TextKeyEntityDao;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("textKeyEntityDao")
public class TextKeyEntityDaoImpl extends GenericEntityDaoImpl<TextKeyEntity> implements TextKeyEntityDao {



    public TextContentEntity getTextContent(String textKey, String isoLangCode) {
        return (TextContentEntity) sessionFactory.getCurrentSession().createQuery("select tc from TextContentEntity tc " +
                                                                                          "join fetch tc.textKeyEntity t " +
                                                                                          "join fetch tc.languageEntity l " +
                                                                                          "where t.key=:textKey " +
                                                                                          "and l.isoCode=:isoLangCode")
                                                 .setString("textKey", textKey)
                                                 .setString("isoLangCode", isoLangCode).uniqueResult();
    }

    @Transactional
    public void deleteTextKey(String textKeyName,String isoLangCode) {
        sessionFactory.getCurrentSession().createQuery("delete from TextContentEntity tc " +
                "where tc.textKeyEntity.key=:textKeyName " +
                "and tc.languageEntity.isoCode=:isoLangCode")
                .setString("textKeyName",textKeyName)
                .setString("isoLangCode", isoLangCode)
                .executeUpdate();
    }

}
