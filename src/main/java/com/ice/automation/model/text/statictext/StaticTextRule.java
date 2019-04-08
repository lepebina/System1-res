package com.ice.automation.model.text.statictext;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity  @Component
@Table(name = "text_rule")
public class StaticTextRule {
    private static final long serialVersionUID = 246622318898586865L;

    @Id
    @GeneratedValue
    @Column(name = "pk_text_rule")
    private Integer id;

    @OneToMany(mappedBy = "staticTextRule", cascade = CascadeType.ALL)
    private List<StaticText> staticTexts = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<StaticText> getStaticTexts() {
        return staticTexts;
    }

    public void setStaticTexts(List<StaticText> staticTexts) {
        this.staticTexts = staticTexts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        StaticTextRule that = (StaticTextRule) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getStaticTexts(), that.getStaticTexts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStaticTexts());
    }
}
