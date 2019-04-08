package com.ice.automation.events.trigger.triggeridevent.impl;


import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.trigger.triggeridevent.TriggeridEvent;
import com.ice.automation.events.trigger.triggeridevent.TriggeridHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;


@Service("TriggeridHandlerImpl")
public class TriggeridHandlerImpl implements TriggeridHandler {
    RestClient restClient = new RestClient();

    @Autowired
    TriggeridEvent triggeridEvent;
    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc= WebUtils.DEFAULT_CHARACTER_ENCODING;

    private String getUrl() {
        return String.format("http://%s:%s/%s",
                host,
                port,
                triggeridEvent.getApiUrl()
        );
     }

    @Override
    public String sendDefaultApi() throws UnsupportedEncodingException {
        this.initApiParam();
        return restClient.post(UriUtils.encodeQuery(getUrl(), enc),triggeridEvent.getJsonObject()).toString();
    }

    @Override
    public String sendCustomApi() throws UnsupportedEncodingException {
        this.initApiParam();
        return restClient.post(UriUtils.encodeQuery(getUrl(), enc),triggeridEvent.getJsonObject()).toString();
    }

    @Override
    public void initApiParam() {
    }
}