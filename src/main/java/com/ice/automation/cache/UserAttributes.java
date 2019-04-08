package com.ice.automation.cache;

import org.springframework.stereotype.Component;


@Component
public class UserAttributes {
    String msisdn;
    String username;
    String password;
    String contract;
    private String msgId;
    private String langCode;
    private CharSequence totalCharges;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getSubscriptionId() {
        //TODO: return the Id from servicename
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    String subscriptionId;

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getLangCode() {
        return langCode;
    }

    public CharSequence getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(CharSequence totalCharges) {
        this.totalCharges = totalCharges;
    }
}
