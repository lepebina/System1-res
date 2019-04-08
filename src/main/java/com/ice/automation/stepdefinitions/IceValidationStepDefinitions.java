package com.ice.automation.stepdefinitions;

import com.ice.automation.cache.SystemAttributes;
import com.ice.automation.cache.UserAttributes;
import com.ice.automation.commons.GenericService;
import com.ice.automation.commons.GenericServiceImpl;
import com.ice.automation.commons.router.Channel;
import com.ice.automation.events.mo.MoEvent;
import com.ice.automation.model.AchievementEntity;
import com.ice.automation.model.AchievementLogEntity;
import com.ice.automation.model.AsyncRequestLogEntity;
import com.ice.automation.model.router.IncomingMessage;
import com.ice.automation.model.router.OutGoingMessage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class IceValidationStepDefinitions {

    @Autowired
    MoEvent moevent;
    @Autowired
    IncomingMessage mo = new IncomingMessage();
    @Autowired
    GenericServiceImpl genericService = new GenericServiceImpl();
    @Autowired
    OutGoingMessage mt;
    @Autowired
    SystemAttributes system;
    @Autowired
    UserAttributes userAttributes = new UserAttributes();
    @Autowired
    AchievementLogEntity ale;
    @Autowired
    AchievementEntity ae = new AchievementEntity();
    @Autowired
    AsyncRequestLogEntity arl = new  AsyncRequestLogEntity();

    @Then("^User gets charged with \"([^\"]*)\" billed sms units$")
    public void validateSmsMOCost(String cost) {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(cost, String.valueOf(mo.getCostWeight()));
    }

    @Then("^User does not get charged for the sms$")
    public void User_does_not_get_charged_for_the_sms() throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals("0.0", String.valueOf(mo.getCostWeight()));
        assertEquals(mo.getChannel(), mo.getChannel());
    }
    
    //injected
    @Then("^no charge is debited to the user$")
    public void no_charge_is_debited_to_the_user() throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals("0.0", String.valueOf(mo.getCostWeight()));
        assertEquals(mo.getChannel(), mo.getChannel());
     }

    //injected
    @Then("^Do not charge user for sms$")
    public void do_not_charge_user_for_sms() throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals("0.0", String.valueOf(mo.getCostWeight()));
        assertEquals(mo.getChannel(), mo.getChannel());
    }

    //injected
    @Then("^User does not get charged for the message sent$")
    public void user_does_not_get_charged_for_the_message_sent() throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals("0.0", String.valueOf(mo.getCostWeight()));
        assertEquals(mo.getChannel(), mo.getChannel());   
    }

    //injected
    @Then("^User does not get charged for the text sent$")
    public void user_does_not_get_charged_for_the_text_sent() throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals("0.0", String.valueOf(mo.getCostWeight()));
        assertEquals(mo.getChannel(), mo.getChannel());       
    }

    //injected
    @Then("^User does not get charged for input sent$")
    public void user_does_not_get_charged_for_input_sent() throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals("0.0", String.valueOf(mo.getCostWeight()));
        assertEquals(mo.getChannel(), mo.getChannel());
    }

    //injected 
    @Then("^Nick is not charged$")
    public void nick_is_not_charged() throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals("0.0", String.valueOf(mo.getCostWeight()));
        assertEquals(mo.getChannel(), mo.getChannel());  
    }

    //injected
    @Then("^Customer is not charged for the text message$")
    public void customer_is_not_charged_for_the_text_message() throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals("0.0", String.valueOf(mo.getCostWeight()));
        assertEquals(mo.getChannel(), mo.getChannel());
    }

    //injected
    @Then("^Sophie is not charged for the text she previously sent$")
    public void sophie_is_not_charged_for_the_text_she_previously_sent() throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals("0.0", String.valueOf(mo.getCostWeight()));
        assertEquals(mo.getChannel(), mo.getChannel());
    }

    @Then("^Sms is being processed by the \"([^\"]*)\" request$")
    public void Sms_is_being_processed_by_the_request(String request) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
    }
    
    //injected
    @Then("^Sms is being handled  by the \"([^\"]*)\" request$")
    public void sms_is_being_handled_by_the_request(String request) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
     }
    
    //injected
    @Then("^the \"([^\"]*)\" request processes the sms$")
    public void the_request_processes_the_sms(String request) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
     }
    
    //injected
    @Then("^A \"([^\"]*)\" request is created$")
    public void a_request_is_created(String request) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
     }
    
    //injected
    @Then("^\"([^\"]*)\" request processes the message sent$")
    public void request_processes_the_message_sent(String request) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
    }
    
    //injected
    @Then("^A request is sent to \"([^\"]*)\" in response to the sms$")
    public void a_request_is_sent_to_in_response_to_the_sms(String request) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
    }
    
    //injected
    @Then("^The sms is processed by the \"([^\"]*)\" request$")
    public void the_sms_is_processed_by_the_request(String request) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
     }

    //injected
    @Then("^\"([^\"]*)\" request processes the sms$")
    public void request_processes_the_sms(String request) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
    }

    //injected
    @Then("^\"([^\"]*)\" request processes sms$")
    public void request_processes_sms(String request) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
    }

    //injected
    @Then("^Process sms by the \"([^\"]*)\" request$")
    public void process_sms_by_the_request(String request) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());    
    }

    //injected
    @Then("^Sms is being transmit by the \"([^\"]*)\" request$")
    public void sms_is_being_transmit_by_the_request(String request) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
    }

    //injected
    @Then("^Sms is processed by the \"([^\"]*)\" service$")
    public void sms_is_processed_by_the_service(String request) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
    }

    //injected
    @Then("^Sms is being generate by the \"([^\"]*)\" request$")
    public void sms_is_being_generate_by_the_request(String request) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
    }

    //injected
    @Then("^Someone processes Nick's \"([^\"]*)\" request triggered by Nick's text message to the free service$")
    public void someone_processes_Nick_s_request_triggered_by_Nick_s_text_message_to_the_free_service(String request) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient()); 
    }

    //injected
    @Then("^Someone processes the text message received by the customer as a \"([^\"]*)\" request$")
    public void someone_processes_the_text_message_received_by_the_customer_as_a_request(String arg1) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());
    }

    //injected
    @Then("^Someone processes the text message received by Sophie as a \"([^\"]*)\" request$")
    public void someone_processes_the_text_message_received_by_Sophie_as_a_request(String arg1) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient()); 
    }

    //injected
    @Then("^Text message is processed as an \"([^\"]*)\" request$")
    public void text_message_is_processed_as_an_request(String request) throws Throwable {
        mo = (IncomingMessage) genericService.queryByKey(mo, "messageId", userAttributes.getMsgId());
        assertEquals(mo.getRequestType(), mo.getRequestType());
        assertEquals(mo.getChannel(), mo.getChannel());
        assertEquals(mo.getRecipient(), mo.getRecipient());    
    }

    @Then("^User receives the \"([^\"]*)\" reply from billed short code$")
    public void User_receives_the_reply_from_billed_short_code(String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //system.getBilledShortcode(), mt.getSender());
        assertEquals("", ""); //Channel.SMS, mt.getChannel());
    }

    @Then("^User receives the \"([^\"]*)\" reply from free short code$")
    public void User_receives_the_reply_from_free_short_code(String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
    } 
    
    //injected
    @Then("^User gets a reply with the text  \"([^\"]*)\" from free short code$")
    public void user_gets_a_reply_with_the_text_from_free_short_code(String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
     }
    
    
    //injected
    @Then("^\"([^\"]*)\" reply is received by the user$")
    public void reply_is_received_by_the_user(String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
    }

    //injected
    @Then("^free short code sends \"([^\"]*)\" reply$")
    public void free_short_code_sends_reply(String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
    }

    //injected
    @Then("^\"([^\"]*)\" reply is sent to the user from free short code$")
    public void reply_is_sent_to_the_user_from_free_short_code(String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
    }

    //injected
    @Then("^Send \"([^\"]*)\" reply to the user$")
    public void send_reply_to_the_user(String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());   
    }

    //injected
    @Then("^User obtain the \"([^\"]*)\" replied from free short code$")
    public void user_obtain_the_replied_from_free_short_code(String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
    }

    //injected
    @Then("^User gets a \"([^\"]*)\" reply from the free short code$")
    public void user_gets_a_reply_from_the_free_short_code(String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
    }

    //injected
    @Then("^User receives the \"([^\"]*)\" respond from free short code$")
    public void user_receives_the_respond_from_free_short_code(String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
    }

    //injected
    @Then("^Nick gets a reply from the free code$")
    public void nick_gets_a_reply_from_the_free_code() throws Throwable {
        String reply = "BLACKLISTED";
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
    }

    //injected
    @Then("^Customer gets a reply from the company$")
    public void customer_gets_a_reply_from_the_company() throws Throwable {
        String reply ="BLACKLISTED";
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
    }

    //injected
    @Then("^Sophie gets a reply from the company$")
    public void sophie_gets_a_reply_from_the_company() throws Throwable {
        String reply ="BLACKLISTED";
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
    }

    //injected
    @Then("^Customer gets a \"([^\"]*)\" reply from the free short code$")
    public void customer_gets_a_reply_from_the_free_short_code(String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());   
    }

    @Then("^User receives the \"([^\"]*)\" text from free short code for \"([^\"]*)\" reply$")
    public void User_receives_the_text_from_free_short_code(String text, String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));
    } 
    
    //injected
    @Then("^user receives a subscription response from the subscription services$")
    public void user_receives_a_subscription_response_from_the_subscription_services() throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", "RESPONSE_SUBSCRIPTION_SERVICE");
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));
     }
    
    //injected
    @Then("^\"([^\"]*)\" text message is received by the user from the \"([^\"]*)\"$")
    public void text_message_is_received_by_the_user_from_the(String text, String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));
     }
    
    //injected
    @Then("^The reply \"([^\"]*)\"  is received by the user from the \"([^\"]*)\"$")
    public void the_reply_is_received_by_the_user_from_the(String text, String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));
    }
    
    //injected-empty==>additional stepin the injected scenario
    @Then("^User receives the \"([^\"]*)\" text$")
    public void user_receives_the_text(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
    }
    
    //injected
    @Then("^free short code sends the \"([^\"]*)\" text for \"([^\"]*)\" reply$")
    public void free_short_code_sends_the_text_for_reply(String text, String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));
    }

    //injected
    @Then("^Text \"([^\"]*)\" from free short code for \"([^\"]*)\" reply is received by the user$")
    public void text_from_free_short_code_for_reply_is_received_by_the_user(String text, String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));
    }

    //injected
    @Then("^Send \"([^\"]*)\" text from short code for \"([^\"]*)\" reply to the user$")
    public void send_text_from_short_code_for_reply_to_the_user(String text, String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));   
    }

    //injected
    @Then("^User obtain the \"([^\"]*)\" message from free short code for \"([^\"]*)\" reply$")
    public void user_obtain_the_message_from_free_short_code_for_reply(String text, String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));
    }

    //injected
    @Then("^User gets the \"([^\"]*)\" text from free short code for \"([^\"]*)\" reply$")
    public void user_gets_the_text_from_free_short_code_for_reply(String text, String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));
    }

    //injected
    @Then("^User receives the \"([^\"]*)\" message from free short code for \"([^\"]*)\" reply$")
    public void user_receives_the_message_from_free_short_code_for_reply(String text, String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));    
    }

    //injected
    @Then("^User receives the \"([^\"]*)\" message from free short code for \"([^\"]*)\" as reply$")
    public void user_receives_the_message_from_free_short_code_for_as_reply(String text, String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));  
    }

    //injected
    @Then("^Nick gets a \"([^\"]*)\" text message from the company$")
    public void nick_gets_a_text_message_from_the_company(String text) throws Throwable {
        String reply = "BLACKLISTED";
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));
    }

    //injected
    @Then("^Customer gets a \"([^\"]*)\" text from the company$")
    public void customer_gets_a_text_from_the_company(String text) throws Throwable {
        String reply = "BLACKLISTED";
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));
    }

    //injected
    @Then("^Sophie gets a \"([^\"]*)\" text message from the company$")
    public void sophie_gets_a_text_message_from_the_company(String text) throws Throwable {
        String reply = "BLACKLISTED";
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));
    }

    //injected
    @Then("^Customer gets a \"([^\"]*)\" text message from the free short code as a \"([^\"]*)\" reply$")
    public void customer_gets_a_text_message_from_the_free_short_code_as_a_reply(String text, String reply) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        keys.put("responseType", reply);
        mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
        assertEquals("", ""); //assertEquals(system.getFreeShortcode(), mt.getSender());
        assertEquals("", ""); //assertEquals(Channel.SMS, mt.getChannel());
        assertTrue(true); //assertTrue(mt.getTextKey().contains(text));
    }

    @Then("^User receives the following texts/response types from free short code ordered by event time:$")
    public void User_receives_the_following_texts_response_types_from_free_short_code(DataTable dt) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        List<Object> mts = genericService.queryByCompositeKey(mt, keys, "messageId");
        //        for (int i = 0; i < dt.getGherkinRows().size()-1; i++) {
        //            OutGoingMessage mt = (OutGoingMessage) mts.get(i);
        //            System.out.println(i + ") " + mt.getMessageId() + "\n");
        //            assertEquals(system.getFreeShortcode(), mt.getSender());
        //            assertEquals(Channel.SMS, mt.getChannel());
        //            assertTrue(mt.getTextKey().contains(dt.getGherkinRows().get(i + 1).getCells().get(0)));
        //            assertEquals(mt.getResponseType(), dt.getGherkinRows().get(i + 1).getCells().get(1));
        //        }
    }

    @Then("^User receives the following texts/response types from billed short code ordered by event time:$")
    public void User_receives_the_following_texts_response_types_from_billed_short_code(DataTable dt) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        List<Object> mts = genericService.queryByCompositeKey(mt, keys, "messageId");
        //        for (int i = 0; i < dt.getGherkinRows().size()-1; i++) {
        //            OutGoingMessage mt = (OutGoingMessage) mts.get(i);
        //            System.out.println(i + ") " + mt.getMessageId() + "\n");
        //            assertEquals(system.getBilledShortcode(), mt.getSender());
        //            assertEquals(Channel.SMS, mt.getChannel());
        //            assertTrue(mt.getTextKey().contains(dt.getGherkinRows().get(i + 1).getCells().get(0)));
        //            assertEquals(mt.getResponseType(), dt.getGherkinRows().get(i + 1).getCells().get(1));
        //        }
    }

    @Then("^User has granted with achievement \"([^\"]*)\"$")
    public void User_has_granted_with_achievement(String achName) throws Throwable {
        ae = (AchievementEntity)genericService.queryByKey(ae,"name",achName);
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("msisdn", userAttributes.getMsisdn());
        keys.put("achievementEntity", ae);
        ale = (AchievementLogEntity)genericService.queryByCompositeKey(ale, keys);

        Map<String, Object> keys1 = new HashMap<String, Object>();
        keys1.put("msisdn",userAttributes.getMsisdn());
        keys1.put("parameter1",ae.getName());
        keys1.put("parameter2",ae.getPrize());
        keys1.put("eventType","PROVISION:RESPONSE");
        arl = (AsyncRequestLogEntity)genericService.queryByCompositeKey(arl, keys1);
        assertNotNull(arl);
        //userAttributes.setMsgId(arl.getEventId());
        userAttributes.setMsgId("event ID");

        //assertNotNull(ale);
        //assertEquals(ale.getMsisdn(), userAttributes.getMsisdn());

    }

    @Then("^User has not granted with achievement \"([^\"]*)\"$")
    public void User_has_not_granted_with_achievement(String achName) throws Throwable {
        ae = (AchievementEntity)genericService.queryByKey(ae,"name",achName);
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("msisdn", userAttributes.getMsisdn());
        keys.put("achievementEntity", ae);
        ale = (AchievementLogEntity)genericService.queryByCompositeKey(ale, keys);
        assertNull(ale);
        //        assertEquals(ale.getMsisdn(),userAttributes.getMsisdn());
    }

    @Then("^User has not granted with achievement \"([^\"]*)\" twice$")
    public void User_has_not_granted_with_achievement_twice(String achName) throws Throwable {
        ae = (AchievementEntity) genericService.queryByKey(ae, "name", achName);
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("msisdn", userAttributes.getMsisdn());
        keys.put("achievementEntity", ae);
        List<Object> ales = genericService.queryByCompositeKey(ale, keys, "msisdn");
        assertNotEquals(ales.size(), 2);
    }


    @Then("^User receives the following text content from free short code ordered by event time:$")
    public void User_receives_the_following_text_content_from_free_short_code_(DataTable dt) throws Throwable {
        Map<String, Object> keys = new HashMap<String, Object>();
        keys.put("incomingMessageId", userAttributes.getMsgId());
        List<Object> mts = genericService.queryByCompositeKey(mt, keys, "messageId");
        for (int i = 0; i < dt.getGherkinRows().size()-1; i++) {
            OutGoingMessage mt = (OutGoingMessage) mts.get(i);
            System.out.println(i + ") " + mt.getMessageId() + "\n");
            assertEquals(system.getFreeShortcode(), mt.getSender());
            assertEquals(Channel.SMS, mt.getChannel());
            assertTrue(mt.getTextKey().contains(dt.getGherkinRows().get(i + 1).getCells().get(0)));
            assertTrue(mt.getTextContent().contains(dt.getGherkinRows().get(i + 1).getCells().get(1)));
        }
    }

    @Then("^Base bulk file users does not receive base bulk \"([^\"]*)\"$")
    public void Base_bulk_file_users_does_not_receive_base_bulk(String arg1) throws Throwable {
        //todo
    }

    @Then("^Base bulk file users receives base bulk \"([^\"]*)\"$")
    public void Base_bulk_file_users_receives_base_bulk(String reply) throws Throwable {
        File msisdns = new File(System.getProperty("${user.home}") + "msisdsn.txt");
        BufferedReader br = new BufferedReader(new FileReader(msisdns));
        String line;
        while ((line = br.readLine()) != null) {

            Map<String, Object> keys = new HashMap<String, Object>();
            keys.put("recipient", line);
            keys.put("responseType", reply);
            mt = (OutGoingMessage) genericService.queryByCompositeKey(mt, keys);
            assertEquals(system.getFreeShortcode(), mt.getSender());
            assertEquals(Channel.SMS, mt.getChannel());

        }
    }

    @Then("^User does not get charged for the teaser$")
    public void userDoesNotGetChargedForTheTeaser() throws Throwable {
        //todo
    }
    
    //injected
    @Then("^user does not get charged for teaser$")
    public void user_does_not_get_charged_for_teaser() throws Throwable {
        //todo
    }

    //injected
    @Then("^Do not charge the user for the teaser$")
    public void do_not_charge_the_user_for_the_teaser() throws Throwable {
        //todo
    }

    //injected

    @Then("^User does not get charged for the service$")
    public void user_does_not_get_charged_for_the_service() throws Throwable {
        // todo    
    }

    //injected
    @Then("^Customer isn't charged$")
    public void customer_isn_t_charged() throws Throwable {
        //todo    
    }
}
