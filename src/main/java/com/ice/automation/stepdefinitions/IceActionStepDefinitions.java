package com.ice.automation.stepdefinitions;

import com.ice.automation.cache.SystemAttributes;
import com.ice.automation.cache.UserAttributes;
import com.ice.automation.events.billing.BillingEvent;
import com.ice.automation.events.billing.impl.BillingEventHandlerImpl;
import com.ice.automation.events.mo.MoEvent;
import com.ice.automation.events.mo.impl.MoHandlerImpl;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Calendar;


public class IceActionStepDefinitions {

    @Autowired
    MoEvent moevent = new MoEvent();
    @Autowired
    MoHandlerImpl mohandler = new  MoHandlerImpl();
    @Autowired
    SystemAttributes system = new SystemAttributes();
    @Autowired
    UserAttributes user = new UserAttributes();
    @Autowired
    BillingEventHandlerImpl billingHandler;
    @Autowired
    BillingEvent billingEvent;
    @Autowired
    UserAttributes userAttributes =new UserAttributes();

    @When("^User sends sms with input \"([^\"]*)\" to billed short code$")
    public void userSendsSmsWithInputToBilledShortcode(String message) throws SQLException, UnsupportedEncodingException, InterruptedException {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getBilledShortcode());
        moevent.setSender(user.getMsisdn());
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }

    @When("^User sends sms with input \"([^\"]*)\" to free short code$")
    public void userSendsSmsWithInputToFreeShortcode(String message) throws SQLException, UnsupportedEncodingException, InterruptedException {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }
    
    //injected
    @When("^User sends SMS with text and freeing teaser \"([^\"]*)\" is triggered$")
    public void user_sends_SMS_with_text_and_freeing_teaser_is_triggered(String message) throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
     }
    
    //injected
    @When("^user sends an SMS with text \"([^\"]*)\" to free short code$")
    public void user_sends_an_SMS_with_text_to_free_short_code(String message) throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
     }
    
    //injected

@When("^user send an SMS with input \"([^\"]*)\"$")
public void user_send_an_SMS_with_input(String message) throws Throwable {
    moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
    userAttributes.setMsgId(moevent.getMoId());
    moevent.setPayload(message);
    moevent.setRecipient(system.getFreeShortcode());
    //moevent.setRecipient("free short code");
    moevent.setSender(user.getMsisdn());
    //moevent.setSender("msisdn");
    mohandler.sendDefaultApi();
    //Thread.sleep(1000);
 }
    
    //injected
    @When("^User register by sending SMS \"([^\"]*)\"$")
    public void user_register_by_sending_SMS(String message) throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
     }
    
    //injected
    @When("^User sends a text with the words  \"([^\"]*)\" to free short code$")
    public void user_sends_a_text_with_the_words_to_free_short_code(String message) throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
       //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }

    //injected
    @When("^User sends sms with the text \"([^\"]*)\" to free short code$")
    public void user_sends_sms_with_the_text_to_free_short_code(String message) throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }

    //injected
    @When("^User sends sms with the the value  \"([^\"]*)\" to free short code$")
    public void user_sends_sms_with_the_the_value_to_free_short_code(String message) throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }


    //injected
    @When("^A sms of the following code is sent \"([^\"]*)\"$")
    public void a_sms_of_the_following_code_is_sent(String message) throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }

    //injected
    @When("^The same user sends a \"([^\"]*)\" sms$")
    public void the_same_user_sends_a_sms(String message) throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        //moevent.setRecipient(system.getFreeShortcode());
        moevent.setRecipient("free short code");
        //moevent.setSender(user.getMsisdn());
        moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }

    //injected
    @When("^A \"([^\"]*)\" sms  is sent by the user$")
    public void a_sms_is_sent_by_the_user(String message) throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }

    //injected
    @When("^\"([^\"]*)\" sms is sent by the user$")
    public void sms_is_sent_by_the_user(String message) throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }
    //injected
    @When("^Sms containing \"([^\"]*)\" input is sent by the user$")
    public void sms_containing_input_is_sent_by_the_user(String message) throws Throwable {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }

    //injected
    @When("^sms with input \"([^\"]*)\" is sent by the user$")
    public void sms_with_input_is_sent_by_the_user(String message) throws Throwable {
    	moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }

    //injected
    @When("^sms with \"([^\"]*)\" input received from the user$")
    public void sms_with_input_received_from_the_user(String message) throws Throwable {
    	moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);   
    }

    //injected
    @When("^sms with \"([^\"]*)\" input is received from the user$")
    public void sms_with_input_is_received_from_the_user(String message) throws Throwable {
    	moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }

    //injected
    @When("^User enter input with value \"([^\"]*)\" to free short code$")
    public void user_enter_input_with_value_to_free_short_code(String message) throws Throwable {
    	moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }

    //injected
    @When("^User enter text with input \"([^\"]*)\" to free short code$")
    public void user_enter_text_with_input_to_free_short_code(String message) throws Throwable {
    	moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }

    //injected
    @When("^User sends a text message with the text \"([^\"]*)\" to the free short code$")
    public void user_sends_a_text_message_with_the_text_to_the_free_short_code(String message) throws Throwable {
    	moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }

    //injected
    @When("^User sends a text message with the input word \"([^\"]*)\" to a free short code$")
    public void user_sends_a_text_message_with_the_input_word_to_a_free_short_code(String message) throws Throwable {
    	moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);
    }

    //injected
    @When("^User submit input with \"([^\"]*)\" to free short code$")
    public void user_submit_input_with_to_free_short_code(String message) throws Throwable {
    	moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000); 
    }

    //injected
    @When("^User submit input \"([^\"]*)\" to free short code$")
    public void user_submit_input_to_free_short_code(String message) throws Throwable {
    	moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000); 

    }

    //injected
    @When("^Nick sends a message to a free service with the number \"([^\"]*)\" to a free code$")
    public void nick_sends_a_message_to_a_free_service_with_the_number_to_a_free_code(String message) throws Throwable {
    	moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);  
    }

    //injected
    @When("^customer sends a text message with the word \"([^\"]*)\" to a  free short code$")
    public void customer_sends_a_text_message_with_the_word_to_a_free_short_code(String message) throws Throwable {
    	moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000); 
    }

    //injected
    @When("^Customer sends a text message to a free service of the copmpany with the word \"([^\"]*)\"$")
    public void customer_sends_a_text_message_to_a_free_service_of_the_copmpany_with_the_word(String message) throws Throwable {
    	moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000); 
    }

    //injected
    @When("^Sophie sends a text message to a free service of the copmpany with the word \"([^\"]*)\" to a free code$")
    public void sophie_sends_a_text_message_to_a_free_service_of_the_copmpany_with_the_word_to_a_free_code(String message) throws Throwable {
    	moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getFreeShortcode());
        //moevent.setRecipient("free short code");
        moevent.setSender(user.getMsisdn());
        //moevent.setSender("msisdn");
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);  
    }


    @When("^User sends sms with input \"([^\"]*)\" to subscription billed short code$")
    public void userSendsSmsWithInputToSubscriptionShortcode(String message) throws SQLException, UnsupportedEncodingException, InterruptedException {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getSubscriptionBilledShortcode());
        moevent.setSender(user.getMsisdn());
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);

    }

    @When("^User sends sms with input \"([^\"]*)\" to subscription free short code$")
    public void userSendsSmsWithInputToSubscriptionFreeShortcode(String message) throws SQLException, UnsupportedEncodingException, InterruptedException {
        moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        userAttributes.setMsgId(moevent.getMoId());
        moevent.setPayload(message);
        moevent.setRecipient(system.getSubscriptionFreeShortcode());
        moevent.setSender(user.getMsisdn());
        mohandler.sendDefaultApi();
        //Thread.sleep(1000);

    }

    @When("^User has played today's game$")
    public void User_has_played_today_s_game() throws Throwable {

        for(int i=0;i<5;i++){
            moevent.setMoId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
            userAttributes.setMsgId(moevent.getMoId());
            moevent.setPayload("1");
            moevent.setRecipient(system.getFreeShortcode());
            //moevent.setRecipient("free short code");
            moevent.setSender(user.getMsisdn());
            //moevent.setSender("msisdn");
            mohandler.sendDefaultApi();
            //Thread.sleep(1000);

        }
    }
}
