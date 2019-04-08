package com.ice.automation.events.operatorconfiguration;

import java.io.UnsupportedEncodingException;

public interface OperatorHandler {

	public String createOperator() throws UnsupportedEncodingException;

	public String editOperator() throws UnsupportedEncodingException;

	public void initApiParam() ;
}