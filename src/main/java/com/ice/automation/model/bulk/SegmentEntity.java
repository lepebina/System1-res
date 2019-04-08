package com.ice.automation.model.bulk;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity  @Component
@Table(name = "segment")
public class SegmentEntity {

    public enum Type {
        SQL, FILE
    }

    @Id
    @GeneratedValue
    @Column(name = "pk_segment_id")
    private long id;
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column
    private String source;

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
