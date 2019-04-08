package com.ice.automation.events.operatorconfiguration.impl;

import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.operatorconfiguration.OperatorEvent;
import com.ice.automation.events.operatorconfiguration.OperatorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;


@Service("OperatorHandlerImpl")
public class OperatorHandlerImpl implements OperatorHandler {
	RestClient restClient= new RestClient();

	@Autowired
    OperatorEvent operatorEvent;

    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc= WebUtils.DEFAULT_CHARACTER_ENCODING;

	private String getUrl()  {
		return String.format("http://%s:%s/%s",
			host,
			port,
                operatorEvent.getApiUrl());
	}



    public String createOperator() throws UnsupportedEncodingException {
        return restClient.put(UriUtils.encodeQuery(getUrl(), enc), operatorEvent.getJsonObject()).toString();
    }

    public String editOperator() throws UnsupportedEncodingException {
        return restClient.post(UriUtils.encodeQuery(getUrl(), enc), operatorEvent.getJsonObject()).toString();
    }

	public void initApiParam()  {
	}
}