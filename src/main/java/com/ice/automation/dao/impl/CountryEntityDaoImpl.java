package com.ice.automation.dao.impl;


import com.ice.automation.dao.CountryEntityDao;
import com.ice.automation.model.cfg.CountryEntity;
import org.springframework.stereotype.Repository;


@Repository("countryEntityDao")
public class CountryEntityDaoImpl extends GenericEntityDaoImpl<CountryEntity> implements CountryEntityDao {
    @Override
    public CountryEntity getCountryByIsoCode(String isoCode) {
        return null;
    }

//    public CountryEntity getCountryByIsoCode(String iso3166Code) {
//        return (CountryEntity) sessionFactory.getCurrentSession().createQuery("select c from CountryEntity c where c.iso3166Code=:iso3166Code").setString("iso3166Code",
//                                                                                                                                                          iso3166Code).uniqueResult();
//    }
}
