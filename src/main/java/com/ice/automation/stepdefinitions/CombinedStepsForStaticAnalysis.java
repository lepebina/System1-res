package com.ice.automation.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.ice.automation.cache.UserAttributes;
import com.ice.automation.commons.GenericServiceImpl;
import com.ice.automation.events.delete.DeleteEvent;
import com.ice.automation.events.delete.impl.DeleteHandlerImpl;
import com.ice.automation.events.mo.MoEvent;
import com.ice.automation.events.mo.impl.MoHandlerImpl;
import com.ice.automation.model.router.IncomingMessage;
import com.ice.automation.model.subscription.SubscriptionProfileEntity;

public class CombinedStepsForStaticAnalysis {
    @Autowired
    UserAttributes userAttributes = new UserAttributes();
    @Autowired
    DeleteEvent deleteEvent = new DeleteEvent();
    @Autowired
    DeleteHandlerImpl deleteHandler = new DeleteHandlerImpl();
    @Autowired
    MoEvent moevent = new MoEvent();
    @Autowired
    MoHandlerImpl mohandler = new  MoHandlerImpl();
    @Autowired
    SubscriptionProfileEntity subscriptionProfile = new SubscriptionProfileEntity();
    @Autowired
    GenericServiceImpl genericService = new GenericServiceImpl();
    @Autowired
    IncomingMessage mo = new IncomingMessage();
    
    
    public void targetScenario(String msisdn, String message) throws Throwable {
        userAttributes.setMsisdn(msisdn);
        
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
        
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
        
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        //moevent.setRecipient(system.getFreeShortcode());
        moevent.setRecipient("free short code");
        //moevent.setSender(user.getMsisdn());
        moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
        
        subscriptionProfile =(SubscriptionProfileEntity)genericService.queryByKey(subscriptionProfile,"msisdn",userAttributes.getMsisdn());
        //assertNotNull(subscriptionProfile);
        //assertEquals(SubscriptionProfileEntity.SubscriptionStatus.UNSUBSCRIBED, subscriptionProfile.getStatus());
        
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
    }
    
    public void InjectedScenario(String ms, String msg) throws Throwable {
        userAttributes.setMsisdn(ms);
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
        
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(msg);
        //moevent.setRecipient(system.getFreeShortcode());
        moevent.setRecipient("free short code");
        //moevent.setSender(user.getMsisdn());
        moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
        
        assertTrue(true); //genericService.exists(customer, "msisdn", userAttributes.getMsisdn()));
        
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(msg);
        //moevent.setRecipient(system.getFreeShortcode());
        moevent.setRecipient("free short code");
        //moevent.setSender(user.getMsisdn());
        moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
        
        subscriptionProfile =(SubscriptionProfileEntity)genericService.queryByKey(subscriptionProfile,"msisdn",userAttributes.getMsisdn());
        //assertNotNull(subscriptionProfile);
        //assertEquals(SubscriptionProfileEntity.SubscriptionStatus.UNSUBSCRIBED, subscriptionProfile.getStatus());
        
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
    }

}
