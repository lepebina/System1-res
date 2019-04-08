package com.ice.automation.stepdefinitions;

import com.ice.automation.cache.UserAttributes;
import com.ice.automation.commons.GenericService;
import com.ice.automation.commons.GenericServiceImpl;
import com.ice.automation.model.subscription.SubscriptionProfileEntity;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;


public class IceSubscriptionUserStepDefinitions {

    @Autowired
    UserAttributes userAttributes = new  UserAttributes();
    @Autowired
    SubscriptionProfileEntity subscriptionProfile = new SubscriptionProfileEntity();
    @Autowired
    GenericServiceImpl genericService = new GenericServiceImpl();

    @Then("^User has subscription profile$")
    public void User_has_profile() throws Throwable {
        subscriptionProfile =(SubscriptionProfileEntity)genericService.queryByKey(subscriptionProfile,"msisdn",userAttributes.getMsisdn());
        //assertNotNull(subscriptionProfile);
        //assertEquals(SubscriptionProfileEntity.SubscriptionStatus.SUBSCRIBED, subscriptionProfile.getStatus());
    }

    @Then("^User is unsubscribed in subscription profile$")
    public void User_is_unsubscribed() throws Throwable {
        subscriptionProfile =(SubscriptionProfileEntity)genericService.queryByKey(subscriptionProfile,"msisdn",userAttributes.getMsisdn());
        //assertNotNull(subscriptionProfile);
        //assertEquals(SubscriptionProfileEntity.SubscriptionStatus.UNSUBSCRIBED, subscriptionProfile.getStatus());
    }

    //injected
    @Then("^The user will be unsubscribed from the profile$")
    public void the_user_will_be_unsubscribed_from_the_profile() throws Throwable {
        subscriptionProfile =(SubscriptionProfileEntity)genericService.queryByKey(subscriptionProfile,"msisdn",userAttributes.getMsisdn());
        //assertNotNull(subscriptionProfile);
        //assertEquals(SubscriptionProfileEntity.SubscriptionStatus.UNSUBSCRIBED, subscriptionProfile.getStatus());    
    }

    @Then("^User has no subscription profile$")
    public void User_has_no_profile() throws Throwable {
        //assertFalse(genericService.exists(subscriptionProfile, "msisdn", userAttributes.getMsisdn()));
    }    
   
    //injected
    @Then("^user has no subscriptions$")
    public void user_has_no_subscriptions() throws Throwable {
        //assertFalse(genericService.exists(subscriptionProfile, "msisdn", userAttributes.getMsisdn()));
     }

    //injected
    @Then("^User has no subscription$")
    public void user_has_no_subscription() throws Throwable {
        //assertFalse(genericService.exists(subscriptionProfile, "msisdn", userAttributes.getMsisdn()));
    }

    //injected
    @Then("^No subscription profile for user$")
    public void no_subscription_profile_for_user() throws Throwable {
        //assertFalse(genericService.exists(subscriptionProfile, "msisdn", userAttributes.getMsisdn()));   
    }

    //injected
    @Then("^Nick does not have a subscription profile$")
    public void nick_does_not_have_a_subscription_profile() throws Throwable {
        //assertFalse(genericService.exists(subscriptionProfile, "msisdn", userAttributes.getMsisdn()));  
    }

    //injected
    @Then("^Customer does not have a subscription profile$")
    public void customer_does_not_have_a_subscription_profile() throws Throwable {
        //assertFalse(genericService.exists(subscriptionProfile, "msisdn", userAttributes.getMsisdn()));

    }

    //injected
    @Then("^Sophie does not have a subscription profile in the company$")
    public void sophie_does_not_have_a_subscription_profile_in_the_company() throws Throwable {
        //assertFalse(genericService.exists(subscriptionProfile, "msisdn", userAttributes.getMsisdn()));  
    }



}
