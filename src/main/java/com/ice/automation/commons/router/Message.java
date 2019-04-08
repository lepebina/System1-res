package com.ice.automation.commons.router;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Message implements Serializable {

    private Channel channel;

    private Map<MessageAttribute, Serializable> messageAttributes = new HashMap<MessageAttribute, Serializable>();

    public Message(Channel channel) {
        this.channel = channel;
    }

    public <V extends Serializable> void addAttribute(MessageAttribute messageAttribute, V value) {
        this.messageAttributes.put(messageAttribute, value);
    }

    public Channel getChannel() {
        return channel;
    }

    public <V extends Serializable> V getAttribute(MessageAttribute messageAttribute) {
        return (V) messageAttributes.get(messageAttribute);
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Map<MessageAttribute, Serializable> getMessageAttributes() {
        return messageAttributes;
    }

    public void setMessageAttributes(Map<MessageAttribute, Serializable> messageAttributes) {
        this.messageAttributes = messageAttributes;
    }
}
