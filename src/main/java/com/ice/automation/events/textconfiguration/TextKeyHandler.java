package com.ice.automation.events.textconfiguration;


import java.io.UnsupportedEncodingException;

public interface TextKeyHandler {

	public String sendDefaultApi() throws UnsupportedEncodingException;

	public String sendCustomApi() ;

	public void initApiParam() ;
}