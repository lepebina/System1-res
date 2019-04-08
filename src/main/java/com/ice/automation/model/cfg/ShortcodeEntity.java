package com.ice.automation.model.cfg;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity  @Component
@Table(name = "cfg_operator_shortcode")
public class ShortcodeEntity {

    public enum Type {
        MO, MT, MO_MT
    }

    @Id
    @GeneratedValue
    @Column(name = "pk_operator_shortcode_id")
    private long id;
    @Column
    private String shortcode;
    @Column(name = "cost_weight")
    private double costWeight;
    @Column
    @Enumerated(EnumType.STRING)
    private Type type;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_operator_id")
    private OperatorEntity operatorEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public double getCostWeight() {
        return costWeight;
    }

    public void setCostWeight(double costWeight) {
        this.costWeight = costWeight;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public OperatorEntity getOperatorEntity() {
        return operatorEntity;
    }

    public void setOperatorEntity(OperatorEntity operatorEntity) {
        this.operatorEntity = operatorEntity;
    }
}
