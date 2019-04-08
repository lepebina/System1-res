package com.ice.automation.events.billing.impl;

import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.billing.BillingEvent;
import com.ice.automation.events.billing.BillingEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;
import java.io.UnsupportedEncodingException;

@Service("BillingEventHandlerImpl")
public class BillingEventHandlerImpl implements BillingEventHandler {

    RestClient getClient = new RestClient();

    @Autowired
    BillingEvent billingEvent = new BillingEvent();

    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc= WebUtils.DEFAULT_CHARACTER_ENCODING;

    private String getUrl()   {
        return String.format("http://%s:%s/%s/%s/charge/%s?chargePoint=%s&eventId=%s&billingResult=%s",
                host,
                port,
                billingEvent.getApiUrl(),
                billingEvent.getMsisdn(),
                billingEvent.getSubId(),
                billingEvent.getChargePoint(),
                billingEvent.getEventId(),
                billingEvent.getBillingResult()
                );
    }

    @Override
    public String charge() throws UnsupportedEncodingException {
        return getClient.get(UriUtils.encodeQuery(getUrl(), enc)).toString();

    }

}