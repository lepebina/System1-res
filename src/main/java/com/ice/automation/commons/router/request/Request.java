package com.ice.automation.commons.router.request;

import com.ice.automation.commons.router.Channel;
import com.ice.automation.commons.router.Message;

import java.io.Serializable;
import java.sql.Timestamp;


public abstract class Request implements Serializable {

    private String requestId;
    private String customerKey;
    private Timestamp requestDate;

    private Channel channel;
    private Message message;

    private Object log;

    public Request(String requestId, Channel channel, String customerKey, Timestamp requestDate) {
        this.requestId = requestId;
        this.channel = channel;
        this.customerKey = customerKey;
        this.requestDate = requestDate;
    }

    public String getRequestId() {
        return requestId;
    }

    public Channel getChannel() {
        return channel;
    }

    public String getCustomerKey() {
        return customerKey;
    }

    public abstract String getLanguageCode();

    public Timestamp getRequestDate() {
        return requestDate;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Object getLog() {
        return log;
    }

    public void setLog(Object log) {
        this.log = log;
    }
}
