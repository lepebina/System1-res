package com.ice.automation.model.keyword;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Table(name = "cfg_keyword_alias")
@Entity  @Component
public class KeywordAliasEntity {

    @Id
    @GeneratedValue
    @Column(name = "pk_keyword_alias_id")
    private long id;
    @Column
    private String alias;
    @Column
    private String regex;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_keyword_id")
    private KeywordEntity keywordEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public KeywordEntity getKeywordEntity() {
        return keywordEntity;
    }

    public void setKeywordEntity(KeywordEntity keywordEntity) {
        this.keywordEntity = keywordEntity;
    }

    @Override
    public String toString() {
        return "KeywordAliasEntity{" +
                "alias='" + alias + '\'' +
                ", regex='" + regex + '\'' +
                ", " + keywordEntity +
                '}';
    }
}
