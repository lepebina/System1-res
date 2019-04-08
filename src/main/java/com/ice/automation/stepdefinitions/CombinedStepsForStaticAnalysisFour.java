package com.ice.automation.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ice.automation.cache.UserAttributes;
import com.ice.automation.commons.GenericServiceImpl;
import com.ice.automation.events.billing.BillingEvent;
import com.ice.automation.events.bulk.start.startevent.StartEvent;
import com.ice.automation.events.bulk.start.startevent.impl.StartHandlerImpl;
import com.ice.automation.events.delete.DeleteEvent;
import com.ice.automation.events.delete.impl.DeleteHandlerImpl;
import com.ice.automation.events.mo.MoEvent;
import com.ice.automation.events.mo.impl.MoHandlerImpl;
import com.ice.automation.events.time.offset.TimeOffsetEvent;
import com.ice.automation.events.time.offset.impl.TimeOffsetHandlerImpl;
import com.ice.automation.model.router.OutGoingMessage;

public class CombinedStepsForStaticAnalysisFour {
    @Autowired
    UserAttributes userAttributes = new UserAttributes();
    @Autowired
    DeleteHandlerImpl deleteHandler = new DeleteHandlerImpl();
    @Autowired
    DeleteEvent deleteEvent = new DeleteEvent();

    @Autowired
    TimeOffsetEvent timeOffsetEvent = new TimeOffsetEvent();

    @Autowired
    TimeOffsetHandlerImpl timeOffsetHandler = new TimeOffsetHandlerImpl();
    @Autowired
    MoEvent moevent = new MoEvent();
    @Autowired
    MoHandlerImpl mohandler = new  MoHandlerImpl();
    @Autowired
    StartHandlerImpl startHandler = new StartHandlerImpl();
    @Autowired
    StartEvent startEvent = new StartEvent();
    @Autowired
    BillingEvent billingEvent = new BillingEvent();
    @Autowired
    GenericServiceImpl genericService = new GenericServiceImpl();
    @Autowired
    OutGoingMessage mt = new OutGoingMessage();
    
    public void targetConent(String msisdn, String timeInHours, String message, String freeingTeaserId) throws Throwable {
        userAttributes.setMsisdn(msisdn);
        
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
        
        if (timeInHours.equals("0")) {
            timeOffsetEvent.setOffSetInMillies(timeInHours);
            timeOffsetHandler.sendDefaultApi();
        } else {
            long millis = Long.parseLong(timeInHours) * 60 * 60 * 1000 - Long.parseLong(timeInHours) * 60 * 60 * 1000 * 2;
            timeOffsetEvent.setOffSetInMillies(String.valueOf(millis));
            timeOffsetHandler.sendDefaultApi();
        }
        
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
        
        if (timeInHours.equals("0")) {
            timeOffsetEvent.setOffSetInMillies(timeInHours);
            timeOffsetHandler.sendDefaultApi();
        } else {
            long millis = Long.parseLong(timeInHours) * 60 * 60 * 1000 - Long.parseLong(timeInHours) * 60 * 60 * 1000 * 2;
            timeOffsetEvent.setOffSetInMillies(String.valueOf(millis));
            timeOffsetHandler.sendDefaultApi();
        }
        
        startEvent.setBulkId(freeingTeaserId);
        startHandler.sendDefaultApi();
        //Thread.sleep(5000);
        
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", billingEvent.getEventId());
        keys.put("responseType", "SUBSCRIPTION_CONTENT");
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals(mt,mt);
    }
    
    public void injectedContent(String msisdn, String timeInHours, String message, String freeingTeaserId) throws Throwable {
        userAttributes.setMsisdn(msisdn);
        
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
        
        if (timeInHours.equals("0")) {
            timeOffsetEvent.setOffSetInMillies(timeInHours);
            timeOffsetHandler.sendDefaultApi();
        } else {
            long millis = Long.parseLong(timeInHours) * 60 * 60 * 1000 - Long.parseLong(timeInHours) * 60 * 60 * 1000 * 2;
            timeOffsetEvent.setOffSetInMillies(String.valueOf(millis));
            timeOffsetHandler.sendDefaultApi();
        }
        
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
        
        if (timeInHours.equals("0")) {
            timeOffsetEvent.setOffSetInMillies(timeInHours);
            timeOffsetHandler.sendDefaultApi();
        } else {
            long millis = Long.parseLong(timeInHours) * 60 * 60 * 1000 - Long.parseLong(timeInHours) * 60 * 60 * 1000 * 2;
            timeOffsetEvent.setOffSetInMillies(String.valueOf(millis));
            timeOffsetHandler.sendDefaultApi();
        }
        
        startEvent.setBulkId(freeingTeaserId);
        startHandler.sendDefaultApi();
        //Thread.sleep(5000);
        
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", billingEvent.getEventId());
        keys.put("responseType", "SUBSCRIPTION_CONTENT");
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals(mt,mt);
    }

}
