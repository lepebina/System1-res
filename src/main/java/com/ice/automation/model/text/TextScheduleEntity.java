package com.ice.automation.model.text;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity  @Component
@Table(name = "text_schedule")
public class TextScheduleEntity {
    private static final long serialVersionUID = -822857565158163173L;

    @Id
    @GeneratedValue
    @Column(name = "pk_text_schedule_id")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "textScheduleEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TextScheduleInstanceEntity> textScheduleInstanceEntities = new ArrayList<>();

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

    public List<TextScheduleInstanceEntity> getTextScheduleInstanceEntities() {
        return textScheduleInstanceEntities;
    }

    public void setTextScheduleInstanceEntities(List<TextScheduleInstanceEntity> textScheduleInstanceEntities) {
        this.textScheduleInstanceEntities = textScheduleInstanceEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TextScheduleEntity that = (TextScheduleEntity) o;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getName(), that.getName())
                && Objects.equals(getTextScheduleInstanceEntities(), that.getTextScheduleInstanceEntities());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTextScheduleInstanceEntities());
    }
}
