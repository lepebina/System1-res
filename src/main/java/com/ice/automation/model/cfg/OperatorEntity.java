package com.ice.automation.model.cfg;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity  @Component
@Table(name = "cfg_operator")
public class OperatorEntity {

    @Id
    @Column(name = "pk_operator_id")
    @GeneratedValue
    private long id;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "fk_util_country_id")
    private CountryEntity countryEntity;
    @OneToMany(mappedBy = "operatorEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ShortcodeEntity> shortcodes = new ArrayList<ShortcodeEntity>();

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

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }

    public List<ShortcodeEntity> getShortcodes() {
        return shortcodes;
    }

    public void setShortcodes(List<ShortcodeEntity> shortcodes) {
        this.shortcodes = shortcodes;
    }
}
