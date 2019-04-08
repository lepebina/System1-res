package com.ice.automation.model.cfg;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  @Component
@Table(name = "util_languages")
public class LanguageEntity {

    public static final LanguageEntity EN_US = new LanguageEntity("English", "en");
    public static final LanguageEntity SQ = new LanguageEntity("Albanian", "sq");

    @Id
    @Column(name = "pk_language_id")
    private long id;
    @Column(name = "language")
    private String lang;
    @Column(name = "iso_639_1_code")
    private String isoCode;

    public LanguageEntity() {
    }

    public LanguageEntity(String lang, String isoCode) {
        this.lang = lang;
        this.isoCode = isoCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }
}
