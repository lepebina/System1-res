package com.ice.automation.events.delete.impl;

import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.delete.DeleteEvent;
import com.ice.automation.events.delete.DeleteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;

@Service("DeleteHandlerImpl")
public class DeleteHandlerImpl implements DeleteHandler {
	RestClient restClient = new RestClient();

	@Autowired
    DeleteEvent deleteEvent = new  DeleteEvent();

    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc= WebUtils.DEFAULT_CHARACTER_ENCODING;

    private String getUrl()   {
        return String.format("http://%s:%s/%s/%s",
                host,
                port,
                deleteEvent.getApiUrl(),
                deleteEvent.getMsisdn());
    }

    public String deleteCustomer() throws UnsupportedEncodingException {
        return restClient.delete(UriUtils.encodeQuery(getUrl(), enc)).toString();
    }

	public void initApiParam()  {
	}
}