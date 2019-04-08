package com.ice.automation.dao;

import com.ice.automation.model.keyword.KeywordAliasEntity;
import com.ice.automation.model.keyword.KeywordEntity;


public interface KeywordEntityDao extends GenericEntityDao<KeywordEntity> {

    KeywordEntity findKeyword(String keywordName);

    KeywordAliasEntity findKeyword(String shortcode, String inputText);

    void delete(long keywordId);
}
