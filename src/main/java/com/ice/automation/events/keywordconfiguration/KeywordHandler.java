package com.ice.automation.events.keywordconfiguration;


import java.io.UnsupportedEncodingException;

public interface KeywordHandler {

	public String create() throws UnsupportedEncodingException;

	public String edit() throws UnsupportedEncodingException;

	public void initApiParam() ;
}