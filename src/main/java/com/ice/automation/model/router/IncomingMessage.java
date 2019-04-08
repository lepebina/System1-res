package com.ice.automation.model.router;

import com.ice.automation.commons.router.Channel;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Component
@Table(name = "messaging_in")
public class IncomingMessage implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "pk_messaging_in")
    private long id;
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
    @Column(name = "request_type")
    private String requestType;
    @Column(name = "cost_weight")
    private double costWeight;
    @Column(name = "cfg_keyword_id")
    private Long keywordId;
    @Column(name = "bulk_text_key")
    private String replyToTextKey;

    public IncomingMessage() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public double getCostWeight() {
        return costWeight;
    }

    public void setCostWeight(double costWeight) {
        this.costWeight = costWeight;
    }

    public Long getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Long keywordId) {
        this.keywordId = keywordId;
    }

    public String getReplyToTextKey() {
        return replyToTextKey;
    }

    public void setReplyToTextKey(String replyToTextKey) {
        this.replyToTextKey = replyToTextKey;
    }
}
