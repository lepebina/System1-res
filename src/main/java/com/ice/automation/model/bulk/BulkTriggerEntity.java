package com.ice.automation.model.bulk;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity  @Component
@Table(name = "bulk_trigger")
public class BulkTriggerEntity {

    @Id @GeneratedValue
    @Column(name = "pk_bulk_trigger_id", nullable = false)
    private long id;
    @Column
    private String name;
    @Column(name = "cron_string")
    private String cron;

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

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}
