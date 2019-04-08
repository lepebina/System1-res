package com.ice.automation.dao.impl;

import com.ice.automation.model.keyword.KeywordAliasEntity;
import com.ice.automation.model.keyword.KeywordEntity;
import com.ice.automation.dao.KeywordEntityDao;
import org.hibernate.CacheMode;
import org.springframework.stereotype.Repository;


@Repository("keywordEntityDao")
public class KeywordEntityDaoImpl extends GenericEntityDaoImpl<KeywordEntity> implements KeywordEntityDao {

    public KeywordEntity findKeyword(String keywordName) {
        return (KeywordEntity) sessionFactory.getCurrentSession().createQuery("select k from KeywordEntity k where k.name=:name").setString("name",
                                                                                                                                            keywordName).uniqueResult();
    }

    public KeywordAliasEntity findKeyword(String shortcode, String inputText) {
        return (KeywordAliasEntity) sessionFactory.getCurrentSession()
                                                  .createQuery("select a from KeywordAliasEntity a "
                                                                       + "join a.keywordEntity k "
                                                                       + "join k.configurations c "
                                                                       + "where ( a.alias=:inputMessage or regexp_like_hql(:inputMessage, a.regex)=1 ) "
                                                                       + "and c.shortcodeEntity.shortcode=:shortcode "
                                                                       + "and k.active=1 "
                                                                       + "order by a.regex desc")
                                                  .setMaxResults(1)
                                                  .setCacheable(true)
                                                  .setCacheMode(CacheMode.NORMAL)
                                                  .setString("inputMessage", inputText)
                                                  .setString("shortcode", shortcode)
                                                  .uniqueResult();
    }

    public void delete(long keywordId) {
        sessionFactory.getCurrentSession().createQuery("delete from KeywordEntity k where k.id=:keywordId").setLong("keywordId", keywordId).executeUpdate();
    }
}
