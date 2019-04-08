package com.ice.automation.model.keyword;

import com.ice.automation.model.cfg.ShortcodeEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity  @Component
@Table(name = "cfg_keyword_configuration")
public class KeywordConfigurationEntity {

    @Id
    @GeneratedValue
    @Column(name = "pk_cfg_keyword_configuration")
    private long id;

    @ManyToOne
    @JoinColumn(name = "fk_shortcode_id")
    private ShortcodeEntity shortcodeEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_keyword_id")
    private KeywordEntity keywordEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ShortcodeEntity getShortcodeEntity() {
        return shortcodeEntity;
    }

    public void setShortcodeEntity(ShortcodeEntity shortcodeEntity) {
        this.shortcodeEntity = shortcodeEntity;
    }

    public KeywordEntity getKeywordEntity() {
        return keywordEntity;
    }

    public void setKeywordEntity(KeywordEntity keywordEntity) {
        this.keywordEntity = keywordEntity;
    }
}
