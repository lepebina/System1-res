package com.ice.automation.model.bulk;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity  @Component
@Table(name = "bulk")
public class BulkEntity {

    @Id
    @GeneratedValue
    @Column(name = "pk_bulk_id")
    private long id;
    @Column(name = "")
    private String name;
    @Column(name = "start_date")
    private Timestamp startDate;
    @Column(name = "end_date")
    private Timestamp endDate;
    @ManyToOne
    @JoinColumn(name = "fk_segment_id")
    private SegmentEntity segmentEntity;
    @ManyToOne
    @JoinColumn(name = "fk_trigger_id")
    private BulkTriggerEntity bulkTriggerEntity;
    //    @Column(name = "executor_name")
    //    private String executorName;
    @Column(name = "executor_threads")
    private int threads;

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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public SegmentEntity getSegmentEntity() {
        return segmentEntity;
    }

    public void setSegmentEntity(SegmentEntity segmentEntity) {
        this.segmentEntity = segmentEntity;
    }

    public BulkTriggerEntity getBulkTriggerEntity() {
        return bulkTriggerEntity;
    }

    public void setBulkTriggerEntity(BulkTriggerEntity bulkTriggerEntity) {
        this.bulkTriggerEntity = bulkTriggerEntity;
    }

    //    public String getExecutorName() {
    //        return executorName;
    //    }
    //
    //    public void setExecutorName(String executorName) {
    //        this.executorName = executorName;
    //    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }
}
