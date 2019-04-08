package com.ice.automation.events.subscriptiontext;


import java.io.UnsupportedEncodingException;

public interface ContentHandler {

	public String sendDefaultApi() throws UnsupportedEncodingException;

	public String sendCustomApi() throws UnsupportedEncodingException;

	public void initApiParam() ;
}