package com.ice.automation.events.trigger.triggeridevent;


import java.io.UnsupportedEncodingException;

public interface TriggeridHandler {

	public String sendDefaultApi() throws UnsupportedEncodingException;

	public String sendCustomApi() throws UnsupportedEncodingException;

	public void initApiParam() ;
}