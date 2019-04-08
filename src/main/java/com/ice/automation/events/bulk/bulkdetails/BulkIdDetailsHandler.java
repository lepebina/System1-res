package com.ice.automation.events.bulk.bulkdetails;

import java.io.UnsupportedEncodingException;

public interface BulkIdDetailsHandler {

	public String sendDefaultApi() throws UnsupportedEncodingException;

	public String sendCustomApi() throws UnsupportedEncodingException;

	public void initApiParam() ;
}