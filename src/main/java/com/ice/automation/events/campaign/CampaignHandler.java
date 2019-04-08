package com.ice.automation.events.campaign;


import java.io.UnsupportedEncodingException;

public interface CampaignHandler {

	public String createCampaign() throws UnsupportedEncodingException;

	public String editCampaign() throws UnsupportedEncodingException;

	public void initApiParam() ;
}