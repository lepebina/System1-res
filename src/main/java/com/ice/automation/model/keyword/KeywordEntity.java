package com.ice.automation.model.keyword;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity  @Component
@Table(name = "cfg_keyword")
public class KeywordEntity {

    @Id
    @GeneratedValue
    @Column(name = "pk_keyword_id")
    private long id;
    @Column
    private String name;
    @Column(name = "keyword_service")
    private String keywordService;
    @Column(name = "keyword_service_helper")
    private String keywordServiceHelper;
    @Column(name = "is_active")
    private boolean active;
    @Column(name = "send_last_cta")
    private boolean sendLastCta;

    @Column(name = "fk_subscription_id")
    private Long subscriptionId;

    @OneToMany(mappedBy = "keywordEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KeywordAliasEntity> aliases = new ArrayList<KeywordAliasEntity>();

    @OneToMany(mappedBy = "keywordEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KeywordConfigurationEntity> configurations = new ArrayList<KeywordConfigurationEntity>();

    @Override
    public String toString() {
        return "KeywordEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keywordService='" + keywordService + '\'' +
                '}';
    }

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

    public String getKeywordService() {
        return keywordService;
    }

    public void setKeywordService(String keywordService) {
        this.keywordService = keywordService;
    }

    public String getKeywordServiceHelper() {
        return keywordServiceHelper;
    }

    public void setKeywordServiceHelper(String keywordServiceHelper) {
        this.keywordServiceHelper = keywordServiceHelper;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isSendLastCta() {
        return sendLastCta;
    }

    public void setSendLastCta(boolean sendLastCta) {
        this.sendLastCta = sendLastCta;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public List<KeywordAliasEntity> getAliases() {
        return aliases;
    }

    public void setAliases(List<KeywordAliasEntity> aliases) {
        this.aliases = aliases;
    }

    public List<KeywordConfigurationEntity> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<KeywordConfigurationEntity> configurations) {
        this.configurations = configurations;
    }
}
