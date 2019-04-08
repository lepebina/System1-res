package com.ice.automation.events.bulk.start.startevent;

import java.io.UnsupportedEncodingException;

public interface StartHandler {

	public String sendDefaultApi() throws UnsupportedEncodingException;

	public String sendCustomApi() throws UnsupportedEncodingException;

	public void initApiParam() ;
}