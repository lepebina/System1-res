package com.ice.automation.events.subscriptionconfiguration;


import java.io.UnsupportedEncodingException;

public interface SubscriptionHandler {

	public String createSubscription() throws UnsupportedEncodingException;

	public String editSubscription() throws UnsupportedEncodingException;

	public void initApiParam() ;
}