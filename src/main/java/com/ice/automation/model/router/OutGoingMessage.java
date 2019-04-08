package com.ice.automation.model.router;

import com.ice.automation.commons.router.Channel;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity  @Component
@Table(name = "messaging_out")
public class OutGoingMessage implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "pk_messaging_out")
    private long id;
    @Column(name = "incoming_message_id")
    private String incomingMessageId;
    @Column(name = "message_id")
    private String messageId;
    @Column
    @Enumerated(EnumType.STRING)
    private Channel channel;
    @Column(name = "event_time")
    private Timestamp eventTime;
    @Column
    private String sender;
    @Column
    private String recipient;
    @Column(name = "response_type")
    private String responseType;
    @Column(name = "text_key")
    private String textKey;
    @Column(name = "text_content")
    private String textContent;

    public OutGoingMessage() {
    }

    public OutGoingMessage(String incomingMessageId, String responseType, String textKey, String textContent) {
        this.incomingMessageId = incomingMessageId;
        this.responseType = responseType;
        this.textKey = textKey;
        this.textContent = textContent;
    }

    public OutGoingMessage(String responseType, String textKey, String textContent) {
        this.responseType = responseType;
        this.textKey = textKey;
        this.textContent = textContent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIncomingMessageId() {
        return incomingMessageId;
    }

    public void setIncomingMessageId(String incomingMessageId) {
        this.incomingMessageId = incomingMessageId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Timestamp getEventTime() {
        return eventTime;
    }

    public void setEventTime(Timestamp eventTime) {
        this.eventTime = eventTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getTextKey() {
        return textKey;
    }

    public void setTextKey(String textKey) {
        this.textKey = textKey;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
