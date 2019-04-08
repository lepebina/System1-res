package com.ice.automation.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@NamedNativeQuery(name = "getProfileByMsisdnWithWriteLock",
        resultClass = CustomerEntity.class,
        query = "select * from customer where msisdn = :msisdn for update of pk_customer_id nowait ")
@Entity  @Component
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @Column(name = "pk_customer_id")
    private long id;
    @Column
    private String msisdn;
    @Column(name = "iso_639_1_language_code")
    private String lang;

    @Transient
    private boolean newCustomer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public boolean isNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(boolean newCustomer) {
        this.newCustomer = newCustomer;
    }
}
