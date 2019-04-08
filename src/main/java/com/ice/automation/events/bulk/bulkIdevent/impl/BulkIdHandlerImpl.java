package com.ice.automation.events.bulk.bulkIdevent.impl;


import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.bulk.bulkIdevent.BulkIdEvent;
import com.ice.automation.events.bulk.bulkIdevent.BulkIdHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;


@Service("BulkIdHandlerImpl")
public class BulkIdHandlerImpl implements BulkIdHandler {
    RestClient restClient = new RestClient();

    @Autowired
    BulkIdEvent bulkIdEvent;
    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc = WebUtils.DEFAULT_CHARACTER_ENCODING;

    private String getUrl() {
        return String.format("http://%s:%s/%s",
                host,
                port,
                bulkIdEvent.getApiUrl());
    }


    @Override
    public String createBulk() throws UnsupportedEncodingException {
        return restClient.put(UriUtils.encodeQuery(getUrl(), enc), bulkIdEvent.getJsonObject()).toString();
    }

    @Override
    public String editBulk() throws UnsupportedEncodingException {
        return restClient.post(UriUtils.encodeQuery(getUrl(), enc),bulkIdEvent.getJsonObject()).toString();
    }

    @Override
    public void initApiParam() {
    }
}