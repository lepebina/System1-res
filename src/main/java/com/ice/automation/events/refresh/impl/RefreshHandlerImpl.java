package com.ice.automation.events.refresh.impl;

import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.refresh.RefreshEvent;
import com.ice.automation.events.refresh.RefreshHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;


@Component
public class RefreshHandlerImpl implements RefreshHandler {
    RestClient getClient = new RestClient();

    @Autowired
    RefreshEvent refreshEvent = new RefreshEvent() ;

    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc= WebUtils.DEFAULT_CHARACTER_ENCODING;

    private String getUrl()   {
        return String.format("http://%s:%s/%s",
                host,
                port,
                refreshEvent.getApiUrl());
    }

    @Override
    public String refreshCache() throws UnsupportedEncodingException {
        return getClient.get(UriUtils.encodeQuery(getUrl(),enc)).toString();
    }
}