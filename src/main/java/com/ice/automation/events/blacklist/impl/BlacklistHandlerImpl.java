package com.ice.automation.events.blacklist.impl;

import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.blacklist.BlacklistEvent;
import com.ice.automation.events.blacklist.BlacklistHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;


@Service("BlacklistHandlerImpl")
public class BlacklistHandlerImpl implements BlacklistHandler {

    RestClient getClient = new RestClient();

    @Autowired
    BlacklistEvent blacklistEvent = new BlacklistEvent();

    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc= WebUtils.DEFAULT_CHARACTER_ENCODING;

    private String getUrl()   {
        return String.format("http://%s:%s/%s?msisdn=%s",
                host,
                port,
                blacklistEvent.getApiUrl(),
                blacklistEvent.getMsisdn());
    }

    @Override
    public String blacklist() throws UnsupportedEncodingException {
        return getClient.put(UriUtils.encodeQuery(getUrl(), enc),"application/json" ).toString();
    }
    @Override
    public String unblacklist() throws UnsupportedEncodingException {
        return getClient.delete(UriUtils.encodeQuery(getUrl(), enc)).toString();
    }
    @Override
    public void initApiParam() {

    }
}