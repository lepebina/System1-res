package com.ice.automation.model.text.pool;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity  @Component
@Table(name = "pool_schedule")
public class PoolScheduleEntity {

    @Id
    @GeneratedValue
    @Column(name = "pk_pool_schedule_id")
    private long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "poolScheduleEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PoolScheduleInstanceEntity> poolScheduleInstanceEntities = new ArrayList<PoolScheduleInstanceEntity>();

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

    public List<PoolScheduleInstanceEntity> getPoolScheduleInstanceEntities() {
        return poolScheduleInstanceEntities;
    }

    public void setPoolScheduleInstanceEntities(List<PoolScheduleInstanceEntity> poolScheduleInstanceEntities) {
        this.poolScheduleInstanceEntities = poolScheduleInstanceEntities;
    }
}
