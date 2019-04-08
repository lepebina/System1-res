package com.ice.automation.model.text;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity  @Component
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("GENERIC")
@Table(name = "text_key")
public class TextKeyEntity {
    private static final long serialVersionUID = 1901026241690700522L;

    public static final TextKeyEntity NULL = new TextKeyEntity();

    @Id
    @GeneratedValue
    @Column(name = "pk_text_key_id")
    private Integer id;

    @Column(name = "text_key", nullable = false, unique = true)
    private String key;

    @OneToMany(mappedBy = "textKeyEntity", cascade = CascadeType.ALL)
    private List<TextContentEntity> textContentEntities = new ArrayList<TextContentEntity>();

    public TextKeyEntity() {
        this.key = "NULL";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<TextContentEntity> getTextContentEntities() {
        return textContentEntities;
    }

    public void setTextContentEntities(List<TextContentEntity> textContentEntities) {
        this.textContentEntities = textContentEntities;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id,key,textContentEntities);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof TextKeyEntity))
            return false;
        TextKeyEntity other = (TextKeyEntity) obj;
        if (id != other.id)
            return false;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        return true;
    }
}
