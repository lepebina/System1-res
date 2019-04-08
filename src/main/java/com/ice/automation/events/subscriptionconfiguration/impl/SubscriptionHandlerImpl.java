package com.ice.automation.events.subscriptionconfiguration.impl;


import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.subscriptionconfiguration.SubscriptionEvent;
import com.ice.automation.events.subscriptionconfiguration.SubscriptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;

@Service("SubscriptionHandlerImpl")
public class SubscriptionHandlerImpl implements SubscriptionHandler {
    RestClient restClient = new RestClient();

    @Autowired
    SubscriptionEvent subscriptionEvent = new SubscriptionEvent();

    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc= WebUtils.DEFAULT_CHARACTER_ENCODING;

    private String getUrl() {
        return String.format("http://%s:%s/%s",
                host,
                port,
                subscriptionEvent.getApiUrl());
    }

    private String getEditUrl() {
        return String.format("http://%s:%s/%s",
                host,
                port,
                subscriptionEvent.getApiEditUrl());
    }

    @Override
    public String createSubscription() throws UnsupportedEncodingException {
        return restClient.put(UriUtils.encodeQuery(getUrl(), enc), subscriptionEvent.getJsonObject()).toString();
    }

    @Override
    public String editSubscription() throws UnsupportedEncodingException {
        return restClient.post(UriUtils.encodeQuery(getEditUrl(), enc), subscriptionEvent.getJsonObject()).toString();

    }

    @Override
    public void initApiParam() {
    }
}