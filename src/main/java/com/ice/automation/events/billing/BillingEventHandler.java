package com.ice.automation.events.billing;

import java.io.UnsupportedEncodingException;

public interface BillingEventHandler {

	public String charge() throws UnsupportedEncodingException;
}