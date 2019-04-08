package com.ice.automation.model.smartfield;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity  @Component
@Table(name = "text_smartfield")
public class SmartfieldEntity {

    public final static char SPECIAL_CHARACTER = '_';

    @Id
    @Column
    private String literal;
    @Column
    private String description;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "max_length")
    private int maxLength;
    @Column
    private String properties;

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
}
