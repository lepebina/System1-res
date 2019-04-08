package com.ice.automation.events.bulk.start.startevent.impl;

import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.bulk.bulkIdevent.BulkIdEvent;
import com.ice.automation.events.bulk.start.startevent.StartEvent;
import com.ice.automation.events.bulk.start.startevent.StartHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;

@Service("StartHandlerImpl")
public class StartHandlerImpl implements StartHandler {
	RestClient restClient = new RestClient();

	@Autowired
	StartEvent startEvent = new StartEvent();
	@Value("#{properties['server_host']}")
	private String host;
	@Value("#{properties['server_port']}")
	private String port;

	String enc = WebUtils.DEFAULT_CHARACTER_ENCODING;

	private String getUrl()  {
		return String.format("http://%s:%s/%s",
			host,
			port,
				String.format(startEvent.getApiUrl(),startEvent.getBulkId()));
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
	public void initApiParam()  {
	}
}