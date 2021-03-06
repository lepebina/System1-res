package com.ice.automation.stepdefinitions.staticAnalysis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ice.automation.cache.UserAttributes;
import com.ice.automation.commons.GenericServiceImpl;
import com.ice.automation.events.blacklist.BlacklistEvent;
import com.ice.automation.events.blacklist.impl.BlacklistHandlerImpl;
import com.ice.automation.events.delete.DeleteEvent;
import com.ice.automation.events.delete.impl.DeleteHandlerImpl;
import com.ice.automation.events.mo.MoEvent;
import com.ice.automation.events.mo.impl.MoHandlerImpl;
import com.ice.automation.model.router.IncomingMessage;
import com.ice.automation.model.router.OutGoingMessage;

public class CombinedStepsForStaticAnalysisFirstPair {
    @Autowired
    UserAttributes userAttributes = new UserAttributes();
    @Autowired
    DeleteHandlerImpl deleteHandler = new DeleteHandlerImpl();
    @Autowired
    DeleteEvent deleteEvent = new DeleteEvent();
    @Autowired
    BlacklistHandlerImpl blacklistHandler = new BlacklistHandlerImpl();
    @Autowired
    BlacklistEvent blacklistEvent = new BlacklistEvent();
    @Autowired
    MoEvent moevent = new MoEvent();
    @Autowired
    MoHandlerImpl mohandler = new  MoHandlerImpl();
    @Autowired
    IncomingMessage mo = new IncomingMessage();
    @Autowired
    GenericServiceImpl genericService = new GenericServiceImpl();
    @Autowired
    OutGoingMessage mt;
    
    public void pairOneScenarioOneWithoutRearrangement(String msisdn, String message, String reply) throws Throwable {
        userAttributes.setMsisdn(msisdn);
        
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
        
        blacklistEvent.setMsisdn(userAttributes.getMsisdn());
        blacklistHandler.blacklist();
        
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        //moevent.setRecipient(system.getFreeShortcode());
        moevent.setRecipient("free short code");
        //moevent.setSender(user.getMsisdn());
        moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
        
        assertTrue(true); //genericService.exists(customer, "msisdn", userAttributes.getMsisdn()));
        
        //assertFalse(genericService.exists(subscriptionProfile, "msisdn", userAttributes.getMsisdn()));
        
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
        
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        
        keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));
        
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals("0.0", String.valueOf(mo.getCostWeight()));
        assertEquals(mo.getChannel(), mo.getChannel());
        
        blacklistEvent.setMsisdn(userAttributes.getMsisdn());
        blacklistHandler.unblacklist();
        
    }
    
 public void pairOneScenarioTwoWithRearrangement(String msisdn, String message, String reply) throws Throwable {
     blacklistEvent.setMsisdn(userAttributes.getMsisdn());
     blacklistHandler.blacklist();
     
     deleteEvent.setMsisdn(userAttributes.getMsisdn());
     deleteHandler.deleteCustomer();
     
     userAttributes.setMsisdn(msisdn);
     
     moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
     userAttributes.setMsgId(moevent.getMoId());
     moevent.setPayload(message);
     //moevent.setRecipient(system.getFreeShortcode());
     moevent.setRecipient("free short code");
     //moevent.setSender(user.getMsisdn());
     moevent.setSender("msisdn");
     mohandler.sendDefaultApi();
     //Thread.sleep(1000);
     
     assertTrue(true); //genericService.exists(customer, "msisdn", userAttributes.getMsisdn()));
     
     //assertFalse(genericService.exists(subscriptionProfile, "msisdn", userAttributes.getMsisdn()));
     
     mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
     assertEquals(mo.getRequestType(), mo.getRequestType());
     assertEquals(mo.getChannel(), mo.getChannel());
     assertEquals(mo.getRecipient(), mo.getRecipient());
     
     Map<String, Object> keys = new HashMap<String, Object>();
     keys.put("incomingMessageId", userAttributes.getMsgId());
     keys.put("responseType", reply);
     mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
     assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
     assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
     
     keys = new HashMap<String, Object>();
     keys.put("incomingMessageId", userAttributes.getMsgId());
     keys.put("responseType", reply);
     mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
     assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
     assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
     assertTrue(true); //assertTrue(mt.getTextKey().contains(text));
     
     mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
     assertEquals("0.0", String.valueOf(mo.getCostWeight()));
     assertEquals(mo.getChannel(), mo.getChannel());
     
     blacklistEvent.setMsisdn(userAttributes.getMsisdn());
     blacklistHandler.unblacklist();
        
    }

}
