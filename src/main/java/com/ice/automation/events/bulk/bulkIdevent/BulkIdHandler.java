package com.ice.automation.events.bulk.bulkIdevent;

import java.io.UnsupportedEncodingException;

public interface BulkIdHandler {

	public String createBulk() throws UnsupportedEncodingException;

	public String editBulk() throws UnsupportedEncodingException;

	public void initApiParam() ;
}