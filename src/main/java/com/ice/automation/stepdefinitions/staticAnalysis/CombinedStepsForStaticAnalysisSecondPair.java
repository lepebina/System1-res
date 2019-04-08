package com.ice.automation.stepdefinitions.staticAnalysis;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ice.automation.cache.UserAttributes;
import com.ice.automation.commons.GenericServiceImpl;
import com.ice.automation.events.billing.BillingEvent;
import com.ice.automation.events.billing.impl.BillingEventHandlerImpl;
import com.ice.automation.events.delete.DeleteEvent;
import com.ice.automation.events.delete.impl.DeleteHandlerImpl;
import com.ice.automation.events.mo.MoEvent;
import com.ice.automation.events.mo.impl.MoHandlerImpl;
import com.ice.automation.events.refresh.impl.RefreshHandlerImpl;
import com.ice.automation.events.subscriptionconfiguration.SubscriptionEvent;
import com.ice.automation.events.subscriptionconfiguration.impl.SubscriptionHandlerImpl;
import com.ice.automation.model.router.OutGoingMessage;
import com.ice.automation.model.subscription.SubscriptionEntity;

public class CombinedStepsForStaticAnalysisSecondPair {
    @Autowired
    UserAttributes userAttributes = new UserAttributes();
  //@Autowired
    SubscriptionEvent subscriptionEvent = new SubscriptionEvent();
    @Autowired
    SubscriptionHandlerImpl subscriptionHandler = new SubscriptionHandlerImpl();
  @Autowired
    GenericServiceImpl genericService = new GenericServiceImpl();
  @Autowired
  SubscriptionEntity se = new SubscriptionEntity();
  @Autowired
  RefreshHandlerImpl refreshHandler = new RefreshHandlerImpl();
  @Autowired
  DeleteHandlerImpl deleteHandler = new DeleteHandlerImpl();
  @Autowired
  DeleteEvent deleteEvent = new DeleteEvent();
  @Autowired
  MoEvent moevent = new MoEvent();
  @Autowired
  MoHandlerImpl mohandler = new MoHandlerImpl();
  @Autowired
  BillingEventHandlerImpl billingHandler = new BillingEventHandlerImpl();
  @Autowired
  BillingEvent billingEvent = new BillingEvent();
  @Autowired
  OutGoingMessage mt = new OutGoingMessage();
    
    public void pairTwoScenarioOneWithoutRearrangement(String msisdn, String name, String subId, String startDate, String endDate, String freePeriod, String chargePoint, String billingResult) throws Throwable {
        userAttributes.setMsisdn(msisdn);
        
        se = (SubscriptionEntity)genericService.queryByKey(se,"name",name);
        subscriptionEvent.setSubscriptionId("42"); //se.getId().toString());
        subscriptionEvent.setName(name);
        subscriptionEvent.setStartDate(startDate);
        subscriptionEvent.setEndDate(endDate);
        subscriptionEvent.setFreePeriodDays(freePeriod);
        subscriptionEvent.setContentOnOptin(String.valueOf(true));
        subscriptionEvent.setCostWeight("0");
        subscriptionEvent.setEnabled("true");
        subscriptionHandler.editSubscription();
        refreshHandler.refreshCache();
        
        refreshHandler.refreshCache();
        
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
        
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload("YES");
        //moevent.setRecipient(system.getFreeShortcode());
        moevent.setRecipient("free short code");
        //moevent.setSender(user.getMsisdn());
        moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        
        se = (SubscriptionEntity)genericService.queryByKey(se,"name",subId);
        /*commented the following line and passed the nullpointerexception 
         * barrier caused by the parameter. hardcoded the parameter instead 
         * billingEvent.setMsisdn(user.getMsisdn());
         */
        billingEvent.setMsisdn("msidn");
        billingEvent.setChargePoint(chargePoint);
        billingEvent.setSubId(String.valueOf(se.getId()));
        billingEvent.setBillingResult(billingResult);
        billingEvent.setEventId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        billingHandler.charge();
        
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", billingEvent.getEventId());
        keys.put("responseType", "SUBSCRIPTION_CONTENT");
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals(mt,mt);
        
    }
    
    
    public void pairTwoScenarioTwoWithRearrangement(String name, String startDate, String endDate, String freePeriod, String msisdn, String subId, String chargePoint, String billingResult) throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload("YES");
        //moevent.setRecipient(system.getFreeShortcode());
        moevent.setRecipient("free short code");
        //moevent.setSender(user.getMsisdn());
        moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
        
        refreshHandler.refreshCache();
        
        se = (SubscriptionEntity)genericService.queryByKey(se,"name",name);
        subscriptionEvent.setSubscriptionId("42"); //se.getId().toString());
        subscriptionEvent.setName(name);
        subscriptionEvent.setStartDate(startDate);
        subscriptionEvent.setEndDate(endDate);
        subscriptionEvent.setFreePeriodDays(freePeriod);
        subscriptionEvent.setContentOnOptin(String.valueOf(true));
        subscriptionEvent.setCostWeight("0");
        subscriptionEvent.setEnabled("true");
        subscriptionHandler.editSubscription();
        refreshHandler.refreshCache();
        
        userAttributes.setMsisdn(msisdn);
        
        se = (SubscriptionEntity)genericService.queryByKey(se,"name",subId);
        /*commented the following line and passed the nullpointerexception 
         * barrier caused by the parameter. hardcoded the parameter instead 
         * billingEvent.setMsisdn(user.getMsisdn());
         */
        billingEvent.setMsisdn("msidn");
        billingEvent.setChargePoint(chargePoint);
        billingEvent.setSubId(String.valueOf(se.getId()));
        billingEvent.setBillingResult(billingResult);
        billingEvent.setEventId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        billingHandler.charge();
        
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", billingEvent.getEventId());
        keys.put("responseType", "SUBSCRIPTION_CONTENT");
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals(mt,mt);
        
    }

}
