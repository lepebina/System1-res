package com.ice.automation.events.message.impl;

import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.delete.DeleteEvent;
import com.ice.automation.events.delete.DeleteHandler;
import com.ice.automation.events.message.MessageEvent;
import com.ice.automation.events.message.MessageHandler;
import com.ice.automation.events.textconfiguration.TextKeyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;


@Service("MessageHandlerImpl")

public class MessageHandlerImpl  implements MessageHandler {
    RestClient restClient = new RestClient();

    @Autowired
    MessageEvent messageEvent;

    @Autowired
    TextKeyEvent textKeyEvent = new TextKeyEvent();


    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc= WebUtils.DEFAULT_CHARACTER_ENCODING;

    private String getUrl()   {
        return String.format("http://%s:%s/%s",
                host,
                port,
                textKeyEvent.getApiUrl()
                );
    }
    private String getDeleteUrl()   {
        return String.format("http://%s:%s/%s/%s",
                host,
                port,
                textKeyEvent.getApiUrl(),
                textKeyEvent.getTextKey()
        );
    }


    public String createMessage() throws UnsupportedEncodingException {
        return restClient.put(UriUtils.encodeQuery(getUrl(),enc),messageEvent.getFinalJson()).toString();
    }



    @Override
    public String deleteMessage() throws UnsupportedEncodingException {
        return restClient.delete(UriUtils.encodeQuery(getDeleteUrl(), enc)).toString();
    }

    public void initApiParam()  {
    }
}
