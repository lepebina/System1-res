package com.ice.automation.model.text;

import com.ice.automation.model.text.statictext.StaticTextRule;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity  @Component
@Table(name = "text_schedule_days")
public class TextScheduleInstanceEntity {
    private static final long serialVersionUID = 5391509363038571016L;

    @Id
    @GeneratedValue
    @Column(name = "pk_text_schedule_days_id")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_text_schedule_id", nullable = false)
    private TextScheduleEntity textScheduleEntity;

    @Column(name = "serve_order")
    private Integer order;

    @Column(name = "date_active")
    private Date date;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_text_rule_id", nullable = false)
    private StaticTextRule staticTextRule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TextScheduleEntity getTextScheduleEntity() {
        return textScheduleEntity;
    }

    public void setTextScheduleEntity(TextScheduleEntity textScheduleEntity) {
        this.textScheduleEntity = textScheduleEntity;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StaticTextRule getStaticTextRule() {
        return staticTextRule;
    }

    public void setStaticTextRule(StaticTextRule staticTextRule) {
        this.staticTextRule = staticTextRule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TextScheduleInstanceEntity that = (TextScheduleInstanceEntity) o;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getTextScheduleEntity(), that.getTextScheduleEntity())
                && Objects.equals(getOrder(), that.getOrder())
                && Objects.equals(getDate(), that.getDate())
                && Objects.equals(getStaticTextRule(), that.getStaticTextRule());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTextScheduleEntity(), getOrder(), getDate(), getStaticTextRule());
    }
}
