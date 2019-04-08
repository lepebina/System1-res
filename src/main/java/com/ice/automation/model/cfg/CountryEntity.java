package com.ice.automation.model.cfg;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity  @Component
@Table(name = "util_country")
public class CountryEntity {

    @Id
    @GeneratedValue
    @Column(name = "pk_country_id")
    private long id;
    @Column
    private String name;
    @Column(name = "iso_3166_code")
    private String iso3166Code;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso3166Code() {
        return iso3166Code;
    }

    public void setIso3166Code(String iso3166Code) {
        this.iso3166Code = iso3166Code;
    }
}
