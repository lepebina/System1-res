package com.ice.automation.model.text.statictext;

import com.ice.automation.model.text.TextKeyEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;



@Entity  @Component
@DiscriminatorValue("STATIC")
public class StaticText extends TextKeyEntity {
    private static final long serialVersionUID = 8959562465691151894L;

    @Column(name = "condition1")
    private String condition;

    @ManyToOne
    @JoinColumn(name = "fk_text_rule")
    private StaticTextRule staticTextRule;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public StaticTextRule getStaticTextRule() {
        return staticTextRule;
    }

    public void setStaticTextRule(StaticTextRule staticTextRule) {
        this.staticTextRule = staticTextRule;
    }
}
