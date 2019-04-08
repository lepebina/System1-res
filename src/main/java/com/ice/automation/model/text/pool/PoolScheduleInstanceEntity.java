package com.ice.automation.model.text.pool;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity  @Component
@Table(name = "pool_schedule_days")
public class PoolScheduleInstanceEntity {

    @Id
    @GeneratedValue
    @Column(name = "pk_pool_schedule_days_id")
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_pool_schedule_id")
    private PoolScheduleEntity poolScheduleEntity;
    @Column(name = "serve_order")
    private Integer order;
    @Column(name = "date_active")
    private Date date;

    @OneToMany(mappedBy = "poolScheduleInstanceEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<QuestionEntity> questions = new ArrayList<QuestionEntity>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PoolScheduleEntity getPoolScheduleEntity() {
        return poolScheduleEntity;
    }

    public void setPoolScheduleEntity(PoolScheduleEntity poolScheduleEntity) {
        this.poolScheduleEntity = poolScheduleEntity;
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

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }
}
