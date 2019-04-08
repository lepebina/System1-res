package com.ice.automation.events.textconfiguration.impl;

import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.textconfiguration.TextKeyEvent;
import com.ice.automation.events.textconfiguration.TextKeyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;

@Service("textKeyHandlerImpl")
public class TextKeyHandlerImpl implements TextKeyHandler {

    RestClient getClient = new RestClient();

    @Autowired
    TextKeyEvent textKeyEvent = new TextKeyEvent();

    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc= WebUtils.DEFAULT_CHARACTER_ENCODING;

    private String getUrl()   {
        return String.format("http://%s:%s/%s/%s?msisdn=%s&language=%s",
                host,
                port,
                textKeyEvent.getApiUrl(),
                textKeyEvent.getTextKey(),
                textKeyEvent.getMsisdn(),
                textKeyEvent.getLanguage());
    }

    @Override
    public String sendDefaultApi() throws UnsupportedEncodingException {
        return getClient.get(UriUtils.encodeQuery(getUrl(), enc)).toString();
    }

    @Override
    public String sendCustomApi() {
        return null;
    }

    @Override
    public void initApiParam() {

    }
}