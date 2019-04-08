package com.ice.automation.events.mo;

import java.io.UnsupportedEncodingException;

public interface MoHandler {

	public String sendDefaultApi() throws UnsupportedEncodingException;

	public String sendCustomApi() throws UnsupportedEncodingException;

	public void initApiParam() ;
}