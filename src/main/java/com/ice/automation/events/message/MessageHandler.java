package com.ice.automation.events.message;

import java.io.UnsupportedEncodingException;



public interface MessageHandler {
    public String deleteMessage() throws UnsupportedEncodingException;

    public void initApiParam() ;
}
