package com.ice.automation.events.mo.impl;

import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.mo.MoEvent;
import com.ice.automation.events.mo.MoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


@Component
public class MoHandlerImpl implements MoHandler {
    RestClient getClient = new RestClient();

    @Autowired
    MoEvent moEvent = new MoEvent();

    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc= WebUtils.DEFAULT_CHARACTER_ENCODING;

    private String getUrl()   {
        return String.format("http://%s:%s/%s?moId=%s&sender=%s&recipient=%s&payload=%s",
                host,
                port,
                moEvent.getApiUrl(),
                moEvent.getMoId(),
                moEvent.getSender(),
                moEvent.getRecipient(),
                moEvent.getPayload());
    }

    @Override
    public String sendDefaultApi() throws UnsupportedEncodingException {
        this.initApiParam();
        return getClient.get(getUrl()).toString();
    }

    @Override
    public String sendCustomApi() throws UnsupportedEncodingException {
        this.initApiParam();
        return getClient.get(URLEncoder.encode(getUrl())).toString();//UriUtils.encodeQuery(getUrl(),enc)).toString();
    }
    @Override
    public void initApiParam() {
    }
}