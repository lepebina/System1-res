package com.ice.automation.events.campaign.impl;

import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.campaign.CampaignEvent;
import com.ice.automation.events.campaign.CampaignHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;

@Service("CampaignHandlerImpl")
public class CampaignHandlerImpl implements CampaignHandler {
	RestClient restClient = new RestClient();

	@Autowired
    CampaignEvent campaignEvent = new  CampaignEvent() ;

    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc= WebUtils.DEFAULT_CHARACTER_ENCODING;

	private String getUrl()  {
		System.out.println("user.home is " + System.getProperty("user.home"));
		return String.format("http://%s:%s/%s",
			host,
			port,
                campaignEvent.getApiUrl());
	}


    public String createCampaign() throws UnsupportedEncodingException {
        campaignEvent.setJsonObject();
        return ""; //restClient.put(UriUtils.encodeQuery(getUrl(), enc), campaignEvent.getJsonObject()).toString();
    }

    public String editCampaign() throws UnsupportedEncodingException {
        campaignEvent.setJsonObject();
        return ""; //restClient.post(UriUtils.encodeQuery(getUrl(), enc), campaignEvent.getJsonObject()).toString();
    }

	public void initApiParam()  {
	}
}