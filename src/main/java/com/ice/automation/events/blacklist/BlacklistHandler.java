package com.ice.automation.events.blacklist;

import java.io.UnsupportedEncodingException;

public interface BlacklistHandler {

	public String blacklist() throws UnsupportedEncodingException;

	public String unblacklist() throws UnsupportedEncodingException;

	public void initApiParam() ;
}