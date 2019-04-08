package com.ice.automation.commons.router.response;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class Response {

    private String responseId;
    private Timestamp responseTime;

    private List<Object> messages = new ArrayList<Object>();

    protected Response(String responseId, Timestamp responseTime) {
        this.responseId = responseId;
        this.responseTime = responseTime;
    }

    public void addOutGoingMessage(Object outGoingMessage) {
        this.messages.add(outGoingMessage);
    }

    public String getResponseId() {
        return responseId;
    }

    public Timestamp getResponseTime() {
        return responseTime;
    }

    public List<Object> getMessages() {
        return messages;
    }
}
