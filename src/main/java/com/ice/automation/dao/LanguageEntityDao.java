package com.ice.automation.dao;

import com.ice.automation.model.cfg.LanguageEntity;

import java.util.List;


public interface LanguageEntityDao {

    List<LanguageEntity> getAllLanguages();

    LanguageEntity getLanguage(String isoCode);
}
