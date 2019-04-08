package com.ice.automation.model.text;

import com.ice.automation.model.cfg.LanguageEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;


@Entity  @Component
@Table(name = "text_content")
public class TextContentEntity {
    private static final long serialVersionUID = 697936414483416347L;

    @Id
    @GeneratedValue
    @Column(name = "pk_text_content_id")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_text_key_id", nullable = false)
    private TextKeyEntity textKeyEntity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_language_id", nullable = false)
    private LanguageEntity languageEntity;

    @Column(name = "content", nullable = false)
    private String textLiteral;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TextKeyEntity getTextKeyEntity() {
        return textKeyEntity;
    }

    public void setTextKeyEntity(TextKeyEntity textKeyEntity) {
        this.textKeyEntity = textKeyEntity;
    }

    public LanguageEntity getLanguageEntity() {
        return languageEntity;
    }

    public void setLanguageEntity(LanguageEntity languageEntity) {
        this.languageEntity = languageEntity;
    }

    public String getTextLiteral() {
        return textLiteral;
    }

    public void setTextLiteral(String textLiteral) {
        this.textLiteral = textLiteral;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TextContentEntity that = (TextContentEntity) o;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getTextKeyEntity(), that.getTextKeyEntity())
                && Objects.equals(getLanguageEntity(), that.getLanguageEntity())
                && Objects.equals(getTextLiteral(), that.getTextLiteral());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTextKeyEntity(), getLanguageEntity(), getTextLiteral());
    }
}
