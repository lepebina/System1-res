package com.ice.automation.events.trigger.triggerdetails;

import java.io.UnsupportedEncodingException;

public interface TriggerDetailsHandler {

	public String sendDefaultApi() throws UnsupportedEncodingException;

	public String sendCustomApi() throws UnsupportedEncodingException;

	public void initApiParam() ;
}