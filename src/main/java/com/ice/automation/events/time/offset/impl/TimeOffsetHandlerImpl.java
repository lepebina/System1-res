package com.ice.automation.events.time.offset.impl;

import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.time.offset.TimeOffsetEvent;
import com.ice.automation.events.time.offset.TimeOffsetHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;


@Service("TimeoffsetHandlerImpl")
public class TimeOffsetHandlerImpl implements TimeOffsetHandler{
    RestClient restClient = new RestClient();

    @Autowired
    TimeOffsetEvent timeOffsetEvent = new TimeOffsetEvent();

    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc = WebUtils.DEFAULT_CHARACTER_ENCODING;

    private String getUrl() {
        return String.format("http://%s:%s/%s",
                host,
                port,
                String.format(timeOffsetEvent.getApiUrl(),timeOffsetEvent.getOffSetInMillies()));
    }


    @Override
    public String sendDefaultApi() throws UnsupportedEncodingException {
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
