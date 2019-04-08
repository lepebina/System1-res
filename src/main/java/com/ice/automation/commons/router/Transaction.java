package com.ice.automation.commons.router;

import com.ice.automation.commons.router.request.Request;
import com.ice.automation.commons.router.response.Response;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Transaction {

    private Request request;
    private Response response;

    private Serializable asyncRequest;
    private Object asyncResponse;

    private Set<Object> objectsToPersist = new HashSet<Object>();

    public Transaction(Request request) {
        this.request = request;
    }

    public void addObjectToPersist(Object objectToPersist) {
        this.objectsToPersist.add(objectToPersist);
    }

    public Request getRequest() {
        return request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Serializable getAsyncRequest() {
        return asyncRequest;
    }

    public void setAsyncRequest(Serializable asyncRequest) {
        this.asyncRequest = asyncRequest;
    }

    public Object getAsyncResponse() {
        return asyncResponse;
    }

    public void setAsyncResponse(Object asyncResponse) {
        this.asyncResponse = asyncResponse;
    }

    public Set<Object> getObjectsToPersist() {
        return objectsToPersist;
    }
}
