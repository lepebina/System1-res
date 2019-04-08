package com.ice.automation.events.keywordconfiguration.impl;

import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.keywordconfiguration.KeywordEvent;
import com.ice.automation.events.keywordconfiguration.KeywordHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;

@Service("KeywordHandlerImpl")
public class KeywordHandlerImpl implements KeywordHandler {
    RestClient restClient = new RestClient();

    @Autowired
    KeywordEvent keywordEvent;

    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc= WebUtils.DEFAULT_CHARACTER_ENCODING;

    private String getUrl() {
        return String.format("http://%s:%s/%s",
                host,
                port,
                keywordEvent.getApiUrl());
    }

    @Override
    public String create() throws UnsupportedEncodingException {
        return restClient.put(UriUtils.encodeQuery(getUrl(), enc), keywordEvent.getJsonObject()).toString();
    }

    @Override
    public String edit() throws UnsupportedEncodingException {
        return restClient.post(UriUtils.encodeQuery(getUrl(), enc), keywordEvent.getJsonObject()).toString();

    }

    @Override
    public void initApiParam() {

    }
}