package com.ice.automation.cache;

import org.springframework.stereotype.Component;


@Component
public class SystemAttributes {

    String billedShortcode;
    String freeShortcode;
    String subscriptionBilledShortcode;
    String subscriptionFreeShortcode;
    String offset;
    String operator;
    private String langCode;

    public String getBilledShortcode() {
        return billedShortcode;
    }

    public void setBilledShortcode(String billedShortcode) {
        this.billedShortcode = billedShortcode;
    }

    public String getFreeShortcode() {
        return freeShortcode;
    }

    public void setFreeShortcode(String freeShortcode) {
        this.freeShortcode = freeShortcode;
    }

    public String getSubscriptionBilledShortcode() {
        return subscriptionBilledShortcode;
    }

    public void setSubscriptionBilledShortcode(String subscriptionBilledShortcode) {
        this.subscriptionBilledShortcode = subscriptionBilledShortcode;
    }

    public String getSubscriptionFreeShortcode() {
        return subscriptionFreeShortcode;
    }

    public void setSubscriptionFreeShortcode(String subscriptionFreeShortcode) {
        this.subscriptionFreeShortcode = subscriptionFreeShortcode;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
}
