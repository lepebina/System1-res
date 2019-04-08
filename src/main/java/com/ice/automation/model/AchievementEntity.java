package com.ice.automation.model;

import com.ice.automation.model.text.TextKeyEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity @Component
@Table(name = "achievements")
public class AchievementEntity implements Serializable {
    private static final long serialVersionUID = -1482885276100973417L;

    @Id
    @GeneratedValue
    @Column(name = "pk_achievements_id", nullable = false, updatable = false)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(name = "condition1", nullable = false)
    private String condition;
    @Column(nullable = false)
    private boolean active;
    @Column(name = "condition_validation_service")
    private String conditionValidationService;
    @Column(name = "action_service_name", nullable = false)
    private String actionServiceName;
    @Column
    private String prize;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_obtained_text_key")
    private TextKeyEntity obtainedText;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AchievementEntity that = (AchievementEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(condition, that.condition) &&
                Objects.equals(actionServiceName, that.actionServiceName) &&
                Objects.equals(prize, that.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, condition, actionServiceName, prize);
    }

    @Override
    public String toString() {
        return "AchievementEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", actionServiceName='" + actionServiceName + '\'' +
                ", conditionValidationService='" + conditionValidationService + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getConditionValidationService() {
        return conditionValidationService;
    }

    public void setConditionValidationService(String conditionValidationService) {
        this.conditionValidationService = conditionValidationService;
    }

    public String getActionServiceName() {
        return actionServiceName;
    }

    public void setActionServiceName(String actionServiceName) {
        this.actionServiceName = actionServiceName;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public TextKeyEntity getObtainedText() {
        return obtainedText;
    }

    public void setObtainedText(TextKeyEntity obtainedText) {
        this.obtainedText = obtainedText;
    }
}
