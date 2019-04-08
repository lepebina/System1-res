package com.ice.automation.events.delete;


import java.io.UnsupportedEncodingException;

public interface DeleteHandler {

	public String deleteCustomer() throws UnsupportedEncodingException;

	public void initApiParam() ;
}