package com.ice.automation.dao;


import com.ice.automation.model.cfg.CountryEntity;


public interface CountryEntityDao {

    CountryEntity getCountryByIsoCode(String isoCode);
}
