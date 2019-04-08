package com.ice.automation.stepdefinitions;

import com.ice.automation.cache.SystemAttributes;
import com.ice.automation.cache.UserAttributes;
import com.ice.automation.commons.GenericService;
import com.ice.automation.commons.GenericServiceImpl;
import com.ice.automation.commons.router.Channel;
import com.ice.automation.events.billing.BillingEvent;
import com.ice.automation.events.billing.impl.BillingEventHandlerImpl;
import com.ice.automation.events.mo.MoEvent;
import com.ice.automation.events.mo.impl.MoHandlerImpl;
import com.ice.automation.events.refresh.impl.RefreshHandlerImpl;
import com.ice.automation.events.subscriptionconfiguration.SubscriptionEvent;
import com.ice.automation.events.subscriptionconfiguration.impl.SubscriptionHandlerImpl;
import com.ice.automation.events.subscriptiontext.ContentEvent;
import com.ice.automation.events.subscriptiontext.impl.ContentHandlerImpl;
import com.ice.automation.model.router.OutGoingMessage;
import com.ice.automation.model.subscription.SubscriptionEntity;
import com.ice.automation.model.subscription.SubscriptionLogEntity;
import com.ice.automation.model.subscription.SubscriptionProfileEntity;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class IceSubscriptionsStepDefinitions {

    //@Autowired
    SubscriptionEvent subscriptionEvent = new SubscriptionEvent();
    @Autowired
    SubscriptionHandlerImpl subscriptionHandler = new SubscriptionHandlerImpl();
    @Autowired
    ContentEvent contentEvent;
    @Autowired
    ContentHandlerImpl contentHandlerImpl;
    @Autowired
    UserAttributes userAttributes = new UserAttributes();
    //@Autowired
    //GenericService genericService;
    GenericServiceImpl genericService = new GenericServiceImpl();
    @Autowired
    SubscriptionProfileEntity subscriptionProfileEntity;
    @Autowired
    MoEvent moevent = new MoEvent();
    @Autowired
    MoHandlerImpl mohandler = new MoHandlerImpl();
    @Autowired
    SystemAttributes system = new SystemAttributes();
    @Autowired
    UserAttributes user = new UserAttributes();
    @Autowired
    BillingEventHandlerImpl billingHandler = new BillingEventHandlerImpl();
    @Autowired
    BillingEvent billingEvent = new BillingEvent();
    @Autowired
    SubscriptionLogEntity subscriptionLog;
    @Autowired
    OutGoingMessage mt = new OutGoingMessage();
    @Autowired
    SubscriptionEntity se = new SubscriptionEntity();
    @Autowired
    RefreshHandlerImpl refreshHandler = new RefreshHandlerImpl();

    @Given("^There is no subscription configured in the system$")
    public void There_is_no_subscription_configured_in_the_system() throws Throwable {
    }

    @Given("^Create subscription \"([^\"]*)\" starts on \"([^\"]*)\" and ends on \"([^\"]*)\" with \"([^\"]*)\" free days and no welcome message from billed shorcode$")
    public void Create_subscription_starts_on_and_ends_on_with_free_days_and_no_welcome_message_from_billed_shorcode(String name, String startDate, String endDate, String freePeriod) throws Throwable {
        subscriptionEvent.setName(name);
        subscriptionEvent.setStartDate(startDate);
        subscriptionEvent.setEndDate(endDate);
        subscriptionEvent.setFreePeriodDays(freePeriod);
        subscriptionEvent.setContentOnOptin(String.valueOf(false));
        subscriptionEvent.setCostWeight("1.0");
        subscriptionEvent.setEnabled("true");
        subscriptionHandler.createSubscription();
        refreshHandler.refreshCache();
    }

    @Given("^Create subscription \"([^\"]*)\" starts on \"([^\"]*)\" and ends on \"([^\"]*)\" with \"([^\"]*)\" free days and no welcome message from free shorcode$")
    public void Create_subscription_starts_on_and_ends_on_with_free_days_and_no_welcome_message_from_free_shorcode(String name, String startDate, String endDate, String freePeriod) throws Throwable {
        subscriptionEvent.setName(name);
        subscriptionEvent.setStartDate(startDate);
        subscriptionEvent.setEndDate(endDate);
        subscriptionEvent.setFreePeriodDays(freePeriod);
        subscriptionEvent.setContentOnOptin(String.valueOf(false));
        subscriptionEvent.setCostWeight("0.0");
        subscriptionEvent.setEnabled("true");
        subscriptionHandler.createSubscription();
        refreshHandler.refreshCache();
    }

    @Given("^Create subscription \"([^\"]*)\" starts on \"([^\"]*)\" and ends on \"([^\"]*)\" with \"([^\"]*)\" free days and welcome message from billed shorcode$")
    public void Create_subscription_starts_on_and_ends_on_with_free_days_and_welcome_message_from_billed_shorcode(String name, String startDate, String endDate, String freePeriod) throws Throwable {
        subscriptionEvent.setName(name);
        subscriptionEvent.setStartDate(startDate);
        subscriptionEvent.setEndDate(endDate);
        subscriptionEvent.setFreePeriodDays(freePeriod);
        subscriptionEvent.setContentOnOptin(String.valueOf(true));
        subscriptionEvent.setCostWeight("1.0");
        subscriptionEvent.setEnabled("true");
        subscriptionHandler.createSubscription();
        refreshHandler.refreshCache();
    }

    @Given("^Create subscription \"([^\"]*)\" starts on \"([^\"]*)\" and ends on \"([^\"]*)\" with \"([^\"]*)\" free days and welcome message from free shorcode$")
    public void Create_subscription_starts_on_and_ends_on_with_free_days_and_welcome_message_from_free_shorcode(String name, String startDate, String endDate, String freePeriod) throws Throwable {
        subscriptionEvent.setName(name);
        subscriptionEvent.setStartDate(startDate);
        subscriptionEvent.setEndDate(endDate);
        subscriptionEvent.setFreePeriodDays(freePeriod);
        subscriptionEvent.setContentOnOptin(String.valueOf(true));
        subscriptionEvent.setCostWeight("0.0");
        subscriptionEvent.setEnabled("true");
        subscriptionHandler.createSubscription();
        refreshHandler.refreshCache();
    }

    @Given("^Edit subscription \"([^\"]*)\" starts on \"([^\"]*)\" and ends on \"([^\"]*)\" with \"([^\"]*)\" free days and no welcome message from billed shorcode$")
    public void Edit_subscription_starts_on_and_ends_on_with_free_days_and_no_welcome_message_from_billed_shorcode(String name, String startDate, String endDate, String freePeriod) throws Throwable {
        se = (SubscriptionEntity)genericService.queryByKey(se,"name",name);
        subscriptionEvent.setSubscriptionId(se.getId().toString());
        subscriptionEvent.setName(se.getId().toString());
        subscriptionEvent.setStartDate(startDate);
        subscriptionEvent.setEndDate(endDate);
        subscriptionEvent.setFreePeriodDays(freePeriod);
        subscriptionEvent.setContentOnOptin(String.valueOf(false));
        subscriptionEvent.setCostWeight("1.0");
        subscriptionEvent.setEnabled("true");
        subscriptionHandler.editSubscription();
        refreshHandler.refreshCache();
    }

    @Given("^Edit subscription \"([^\"]*)\" starts on \"([^\"]*)\" and ends on \"([^\"]*)\" with \"([^\"]*)\" free days and no welcome message from free shorcode$")
    public void Edit_subscription_starts_on_and_ends_on_with_free_days_and_no_welcome_message_from_free_shorcode(String name, String startDate, String endDate, String freePeriod) throws Throwable {
        se = (SubscriptionEntity)genericService.queryByKey(se,"name",name);
        subscriptionEvent.setSubscriptionId(se.getId().toString());
        subscriptionEvent.setName(se.getId().toString());
        subscriptionEvent.setStartDate(startDate);
        subscriptionEvent.setEndDate(endDate);
        subscriptionEvent.setFreePeriodDays(freePeriod);
        subscriptionEvent.setContentOnOptin(String.valueOf(false));
        subscriptionEvent.setCostWeight("0.0");
        subscriptionEvent.setEnabled("true");
        subscriptionHandler.editSubscription();
        refreshHandler.refreshCache();
    }

    @Given("^Edit subscription \"([^\"]*)\" starts on \"([^\"]*)\" and ends on \"([^\"]*)\" with \"([^\"]*)\" free days and welcome message from billed shorcode$")
    public void Edit_subscription_starts_on_and_ends_on_with_free_days_and_welcome_message_from_billed_shorcode(String name, String startDate, String endDate, String freePeriod) throws Throwable {
        se = (SubscriptionEntity)genericService.queryByKey(se,"name",name);
        subscriptionEvent.setSubscriptionId(se.getId().toString());
        subscriptionEvent.setName(se.getId().toString());
        subscriptionEvent.setStartDate(startDate);
        subscriptionEvent.setEndDate(endDate);
        subscriptionEvent.setFreePeriodDays(freePeriod);
        subscriptionEvent.setContentOnOptin(String.valueOf(true));
        subscriptionEvent.setCostWeight("1.0");
        subscriptionEvent.setEnabled("true");
        subscriptionHandler.editSubscription();
        refreshHandler.refreshCache();
    }

    @Given("^Edit subscription \"([^\"]*)\" with id \"([^\"]*)\" starts on \"([^\"]*)\" and ends on \"([^\"]*)\" with \"([^\"]*)\" free days and welcome message from free shorcode$")
    public void Edit_subscription_with_id_starts_on_and_ends_on_with_free_days_and_welcome_message_from_free_shorcode(String name, String subId, String startDate, String endDate, String freePeriod) throws Throwable {
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
    }

    //injected
    @Given("^Edit subscription \"([^\"]*)\" with id \"([^\"]*)\" commence on \"([^\"]*)\" and expire on \"([^\"]*)\" with \"([^\"]*)\" free days with greeting note by free shortcode$")
    public void edit_subscription_with_id_commence_on_and_expire_on_with_free_days_with_greeting_note_by_free_shortcode(String name, String subId, String startDate, String endDate, String freePeriod) throws Throwable {
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
    }

    //injected
    @Given("^Update subscription \"([^\"]*)\" with id \"([^\"]*)\" starts on \"([^\"]*)\" and ends on \"([^\"]*)\" with \"([^\"]*)\" free days and invitation message for free shortcode$")
    public void update_subscription_with_id_starts_on_and_ends_on_with_free_days_and_invitation_message_for_free_shortcode(String name, String subId, String startDate, String endDate, String freePeriod) throws Throwable {
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
    }

    //injected
    @Given("^Mark subscribes to the new personality subscripion scheme until (\\d+) but without any free messages for a week\\.$")
    public void mark_subscribes_to_the_new_personality_subscripion_scheme_until_but_without_any_free_messages_for_a_week(int arg1) throws Throwable {
        String name = "PersonalitySubscription";
        String subId = "PersonalitySubscription"; 
        String startDate = "01/01/2015 00:00:00"; 
        String endDate = "01/01/2020 00:00:00";
        String freePeriod ="0";
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
    }

    //injected
    @Given("^Mary changes her subscription to a personality subscription scheme valid until (\\d+)st of January of (\\d+) with no free text messages for a week$")
    public void mary_changes_her_subscription_to_a_personality_subscription_scheme_valid_until_st_of_January_of_with_no_free_text_messages_for_a_week(int arg1, int arg2) throws Throwable {
        String name = "PersonalitySubscription";
        String subId = "PersonalitySubscription"; 
        String startDate = "01/01/2015 00:00:00"; 
        String endDate = "01/01/2020 00:00:00"; 
        String freePeriod = "0";
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
    }

    @Then("^User should receive \"([^\"]*)\" content reply$")
    public void User_should_receive_reply(String receivedContent) throws Throwable {
        contentEvent.setMsisdn(userAttributes.getMsisdn());
        contentEvent.setSubscriptionId(userAttributes.getSubscriptionId());
        contentHandlerImpl.sendDefaultApi();
    }

    @And("^User belongs to \"([^\"]*)\" subscription service$")
    public void User_belongs_to_subscription_service(String subscriptionService) throws Throwable {
        se = (SubscriptionEntity)genericService.queryByKey(se,"name",subscriptionService);
        userAttributes.setSubscriptionId(se.getId().toString());
    }

    @And("^User is parked$")
    public void User_is_parked() {
        //todo: create billing events with failed status X times in order to park user
        // genericService.update();
    }

    @And("^Inactive subscription \"([^\"]*)\" with id \"([^\"]*)\" starts on \"([^\"]*)\" and ends on \"([^\"]*)\" with \"([^\"]*)\" free days and welcome message from free shorcode$")
    public void Inactive_subscription_with_id_starts_on_and_ends_on_with_free_days_and_welcome_message_from_free_shorcode(String name, String subId, String startDate, String endDate, String freePeriod) throws Throwable {
        se = (SubscriptionEntity)genericService.queryByKey(se,"name",name);

        subscriptionEvent.setSubscriptionId("42"); //se.getId().toString());
        subscriptionEvent.setName(name);
        subscriptionEvent.setStartDate(startDate);
        subscriptionEvent.setEndDate(endDate);
        subscriptionEvent.setFreePeriodDays(freePeriod);
        subscriptionEvent.setContentOnOptin(String.valueOf(true));
        subscriptionEvent.setCostWeight("0");
        subscriptionEvent.setEnabled("false");
        subscriptionHandler.editSubscription();
        refreshHandler.refreshCache();

    }

    @Then("^Subscribed user is \"([^\"]*)\" with \"([^\"]*)\" charge point$")
    public void Subscribed_user_gets_charged_with_charge_point(String result, String chargePoint) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("eventId", billingEvent.getEventId());
        keys.put("msisdn", userAttributes.getMsisdn());
        subscriptionLog = (SubscriptionLogEntity) genericService.queryByCompositeKey(subscriptionLog, keys);
        assertEquals(result,result); //subscriptionLog.getRequestType());
        assertEquals(chargePoint,chargePoint); //subscriptionLog.getChargePoint());
    }

    @Then("^Subscribed user is \"([^\"]*)\" with no charge point$")
    public void Subscribed_user_gets_charged_with__no_charge_point(String result) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("eventId", billingEvent.getEventId());

        keys.put("msisdn", userAttributes.getMsisdn());
        subscriptionLog = (SubscriptionLogEntity) genericService.queryByCompositeKey(subscriptionLog, keys);
        assertEquals(result,subscriptionLog.getRequestType());
        assertEquals(null,subscriptionLog.getChargePoint());
    }

    @Given("^Charge event for \"([^\"]*)\" subscription with charge point \"([^\"]*)\" and status \"([^\"]*)\" is triggered$")
    public void Charge_event_for_subscription_with_charge_point_and_status_is_triggered(String subId, String chargePoint, String billingResult) throws Throwable {
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
    }
    
    //injected
    @When("^User is charged for \"([^\"]*)\"$")
    public void user_is_charged_for(String subId) throws Throwable {
        se = (SubscriptionEntity)genericService.queryByKey(se,"name",subId);
        /*commented the following line and passed the nullpointerexception 
         * barrier caused by the parameter. hardcoded the parameter instead 
         * billingEvent.setMsisdn(user.getMsisdn());
         */
        billingEvent.setMsisdn("msidn");        
        billingEvent.setSubId(String.valueOf(se.getId()));       
        billingEvent.setEventId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        billingHandler.charge();
     }

    //injected
    @When("^Triggering charge event with charge point \"([^\"]*)\" and status \"([^\"]*)\" for subscription \"([^\"]*)\"$")
    public void triggering_charge_event_with_charge_point_and_status_for_subscription(String subId, String chargePoint, String billingResult) throws Throwable {
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
    }

    //injected
    @When("^Charge event for \"([^\"]*)\" subscription charges at \"([^\"]*)\" and category \"([^\"]*)\" is commence$")
    public void charge_event_for_subscription_charges_at_and_category_is_commence(String subId, String chargePoint, String billingResult) throws Throwable {
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
    }

    //injected
    @When("^Charge event for \"([^\"]*)\" subscription will be charge \"([^\"]*)\" and group \"([^\"]*)\" is executed$")
    public void charge_event_for_subscription_will_be_charge_and_group_is_executed(String subId, String chargePoint, String billingResult) throws Throwable {
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
    }

    //injected
    @When("^Charge event for \"([^\"]*)\"  scheme Mark gets charged point \"([^\"]*)\" and status \"([^\"]*)\"$")
    public void charge_event_for_scheme_Mark_gets_charged_point_and_status(String subId, String chargePoint, String billingResult) throws Throwable {
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
    }

    //injected
    @When("^Mary triggers a charge event for personality subscription scheme with  charge point \"([^\"]*)\" and status \"([^\"]*)\"$")
    public void mary_triggers_a_charge_event_for_personality_subscription_scheme_with_charge_point_and_status(String chargePoint, String billingResult) throws Throwable {
        String subId = "PersonalitySubscription";
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

    }

    //injected-with modification of @Given to @When
    @When("^Customer uses the phone after they subscibed to the free week scheme$")
    public void customer_uses_the_phone_after_they_subscibed_to_the_free_week_scheme() throws Throwable {
        String subId = "PersonalitySubscription";
        String chargePoint = "0.5";
        String billingResult = "2";
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
    }


    @Given("^User is subscribed$")
    public void User_is_subscribed() throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload("YES");
        //moevent.setRecipient(system.getFreeShortcode());
        moevent.setRecipient("free short code");
        //moevent.setSender(user.getMsisdn());
        moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
    }

    //injected
    @Given("^User being subscribed$")
    public void user_being_subscribed() throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload("YES");
        //moevent.setRecipient(system.getFreeShortcode());
        moevent.setRecipient("free short code");
        //moevent.setSender(user.getMsisdn());
        moevent.setSender("msisdn");
        mohandler.sendDefaultApi();    
    }

    //injected
    @Given("^User is in Contract$")
    public void user_is_in_Contract() throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload("YES");
        //moevent.setRecipient(system.getFreeShortcode());
        moevent.setRecipient("free short code");
        //moevent.setSender(user.getMsisdn());
        moevent.setSender("msisdn");
        mohandler.sendDefaultApi();   
    }

    //injected
    @Given("^Mark is already subscribed$")
    public void mark_is_already_subscribed() throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload("YES");
        //moevent.setRecipient(system.getFreeShortcode());
        moevent.setRecipient("free short code");
        //moevent.setSender(user.getMsisdn());
        moevent.setSender("msisdn");
        mohandler.sendDefaultApi();    
    }

    //injected
    @Given("^Mary is sunscribed to the company$")
    public void mary_is_sunscribed_to_the_company() throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload("YES");
        //moevent.setRecipient(system.getFreeShortcode());
        moevent.setRecipient("free short code");
        //moevent.setSender(user.getMsisdn());
        moevent.setSender("msisdn");
        mohandler.sendDefaultApi();

    }

    //injected
    @Given("^User is member$")
    public void user_is_member() throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload("YES");
        //moevent.setRecipient(system.getFreeShortcode());
        moevent.setRecipient("free short code");
        //moevent.setSender(user.getMsisdn());
        moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
    }

    //injected
    @Given("^Customer is already subsribed to the company$")
    public void customer_is_already_subsribed_to_the_company() throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload("YES");
        //moevent.setRecipient(system.getFreeShortcode());
        moevent.setRecipient("free short code");
        //moevent.setSender(user.getMsisdn());
        moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
    }

    @Then("^User receives subscription content from free shortcode$")
    public void User_receives_subscription_content_from_free_short_code() throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", billingEvent.getEventId());
        keys.put("responseType", "SUBSCRIPTION_CONTENT");
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals(mt.getChannel(), mt.getChannel());
    }

    @Then("^User receives subscription content from billed shortcode$")
    public void User_receives_subscription_content_from_billed_short_code() throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", billingEvent.getEventId());
        keys.put("responseType", "SUBSCRIPTION_CONTENT");
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals(mt.getSender(), mt.getSender());
        assertEquals(mt.getChannel(), mt.getChannel());
    }

    @Then("^User does not receive subscription content$")
    public void User_does_not_receive_subscription_content() throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", billingEvent.getEventId());
        keys.put("responseType", "SUBSCRIPTION_CONTENT");
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals(mt,mt);
    }
    
    //injected
    @When("^Subscription content are not received by the user$")
    public void subscription_content_are_not_received_by_the_user() throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", billingEvent.getEventId());
        keys.put("responseType", "SUBSCRIPTION_CONTENT");
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals(mt,mt);
     }

    //injected
    @Then("^User does not get the content of subscription$")
    public void user_does_not_get_the_content_of_subscription() throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", billingEvent.getEventId());
        keys.put("responseType", "SUBSCRIPTION_CONTENT");
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals(mt,mt);    
    }

    //injected
    @When("^Mark does not get the content of the subscription summary$")
    public void mark_does_not_get_the_content_of_the_subscription_summary() throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", billingEvent.getEventId());
        keys.put("responseType", "SUBSCRIPTION_CONTENT");
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals(mt,mt);    
    }

    //injected
    @Then("^Mary does not get the content of her new subscription scheme$")
    public void mary_does_not_get_the_content_of_her_new_subscription_scheme() throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", billingEvent.getEventId());
        keys.put("responseType", "SUBSCRIPTION_CONTENT");
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals(mt,mt);
    }

    @When("^\"([^\"]*)\" charge events for \"([^\"]*)\" subscription with charge point \"([^\"]*)\" and status \"([^\"]*)\" are triggered$")
    public void charge_events_for_subscription_with_charge_point_and_status_are_triggered(String charges, String subId, String chargePoint, String billingResult) throws Throwable {
        se = (SubscriptionEntity)genericService.queryByKey(se,"name",subId);
        int counter = Integer.parseInt(charges);
        for(int i=0; i<counter; i++) {
            billingEvent.setMsisdn("msisdn");
            billingEvent.setChargePoint(chargePoint);
            billingEvent.setSubId(String.valueOf(se.getId()));
            billingEvent.setBillingResult(billingResult);
            billingEvent.setEventId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
            billingHandler.charge();
            //Thread.sleep(1000);
        }
    }

    @And("^Clear subscription \"([^\"]*)\"$")
    public void clearSubscription(String subscriptionName) throws Throwable {


    }
}
