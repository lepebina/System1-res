package com.ice.automation.events.subscriptiontext.impl;

import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.subscriptiontext.ContentEvent;
import com.ice.automation.events.subscriptiontext.ContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;

@Service("ContentHandlerImpl")
public class ContentHandlerImpl implements ContentHandler {
    RestClient restClient = new RestClient();

    @Autowired
    ContentEvent contentEvent;

    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc= WebUtils.DEFAULT_CHARACTER_ENCODING;

    private String getUrl() {
        return String.format("http://%s:%s/%s?subscriptionId=%s&msisdn=%s",
                host,
                port,
                contentEvent.getApiUrl(),
                contentEvent.getSubscriptionId(),
                contentEvent.getMsisdn());
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