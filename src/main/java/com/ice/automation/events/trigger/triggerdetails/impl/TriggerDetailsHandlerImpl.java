package com.ice.automation.events.trigger.triggerdetails.impl;


import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.bulk.bulkIdevent.BulkIdEvent;
import com.ice.automation.events.bulk.bulkIdevent.BulkIdHandler;
import com.ice.automation.events.trigger.triggerdetails.TriggerDetailsHandler;
import com.ice.automation.events.trigger.triggeridevent.TriggeridEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;


@Service("TriggerDetailsHandlerImpl")
public class TriggerDetailsHandlerImpl implements TriggerDetailsHandler{
    RestClient restClient = new RestClient();

    @Autowired
    TriggeridEvent triggeridEvent;
    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc = WebUtils.DEFAULT_CHARACTER_ENCODING;

    private String getUrl() {
        return String.format("http://%s:%s/%s/%s",
                host,
                port,
                triggeridEvent.getApiUrl(),triggeridEvent.getId());
    }


    @Override
    public String sendDefaultApi() throws UnsupportedEncodingException {
        this.initApiParam();
        return restClient.get(UriUtils.encodeQuery(getUrl(), enc)).toString();
    }

    @Override
    public String sendCustomApi() throws UnsupportedEncodingException {
        this.initApiParam();
        return restClient.get(UriUtils.encodeQuery(getUrl(), enc)).toString();
    }

    @Override
    public void initApiParam() {
    }
}