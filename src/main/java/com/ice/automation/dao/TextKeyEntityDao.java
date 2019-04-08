package com.ice.automation.dao;

import com.ice.automation.model.text.TextContentEntity;
import com.ice.automation.model.text.TextKeyEntity;
import org.springframework.stereotype.Component;


@Component
public interface TextKeyEntityDao extends GenericEntityDao<TextKeyEntity> {

    TextContentEntity getTextContent(String textKey, String isoLangCode);
    void deleteTextKey(String textKeyName,String isoLangCode);
}
