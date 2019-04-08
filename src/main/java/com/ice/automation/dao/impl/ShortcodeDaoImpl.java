package com.ice.automation.dao.impl;

import com.ice.automation.model.cfg.ShortcodeEntity;
import com.ice.automation.model.keyword.KeywordEntity;
import com.ice.automation.dao.ShortcodeDao;
import org.springframework.stereotype.Repository;

@Repository("shortcodeDao")
public class ShortcodeDaoImpl extends GenericEntityDaoImpl<KeywordEntity> implements ShortcodeDao {

    public ShortcodeEntity getShortcode(String operator, String countryCode, String shortcode) {
        return (ShortcodeEntity) sessionFactory.getCurrentSession().createQuery(
                "select s from ShortcodeEntity s " +
                        "join s.operatorEntity o " +
                        "join o.countryEntity c " +
                        "where s.shortcode=:shortcode " +
                        "and o.name=:operatorName " +
                        "and c.iso3166Code=:iso3166Code")
                                               .setString("shortcode", shortcode)
                                               .setString("operatorName", operator)
                                               .setString("iso3166Code", countryCode)
                                               .uniqueResult();
    }
}
