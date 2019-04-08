package com.ice.automation.events.keywordconfiguration;

import org.springframework.stereotype.Component;

@Component
public class KeywordConfiguration {

    String operator;
    String countryCode;
    String shortCode;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
}
