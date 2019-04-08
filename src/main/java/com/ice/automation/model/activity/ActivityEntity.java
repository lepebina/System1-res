package com.ice.automation.model.activity;

import com.ice.automation.model.text.pool.PoolScheduleEntity;
import com.ice.automation.model.text.statictext.StaticTextRule;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity  @Component
@Table(name = "activity")
public class ActivityEntity {

    public enum Type {
        PERSONALITY_TEST
    }

    @Id
    @Column(name = "pk_activity_id")
    @GeneratedValue
    private long id;
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "fk_pool_schedule_id")
    private PoolScheduleEntity poolScheduleEntity;
    @ManyToOne
    @JoinColumn(name = "fk_text_rule_id")
    private StaticTextRule endOfSessionReply;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public PoolScheduleEntity getPoolScheduleEntity() {
        return poolScheduleEntity;
    }

    public void setPoolScheduleEntity(PoolScheduleEntity poolScheduleEntity) {
        this.poolScheduleEntity = poolScheduleEntity;
    }

    public StaticTextRule getEndOfSessionReply() {
        return endOfSessionReply;
    }

    public void setEndOfSessionReply(StaticTextRule endOfSessionReply) {
        this.endOfSessionReply = endOfSessionReply;
    }
}
