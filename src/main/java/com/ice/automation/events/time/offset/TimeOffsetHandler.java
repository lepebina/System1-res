package com.ice.automation.events.time.offset;

import java.io.UnsupportedEncodingException;


public interface TimeOffsetHandler {

    public String sendDefaultApi() throws UnsupportedEncodingException;

    public String sendCustomApi() throws UnsupportedEncodingException;

    public void initApiParam() ;
}
