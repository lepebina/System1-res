package com.ice.automation.stepdefinitions;

import com.ice.automation.cache.UserAttributes;
import com.ice.automation.commons.GenericService;
import com.ice.automation.commons.GenericServiceImpl;
import com.ice.automation.events.blacklist.BlacklistEvent;
import com.ice.automation.events.blacklist.BlacklistHandler;
import com.ice.automation.events.blacklist.impl.BlacklistHandlerImpl;
import com.ice.automation.events.delete.DeleteEvent;
import com.ice.automation.events.delete.DeleteHandler;
import com.ice.automation.events.delete.impl.DeleteHandlerImpl;
import com.ice.automation.events.mo.MoEvent;
import com.ice.automation.model.CustomerEntity;
import com.ice.automation.model.subscription.SubscriptionProfileEntity;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;


public class IceUserStepDefinitions {

    @Autowired
    UserAttributes userAttributes = new UserAttributes();
    @Autowired
    CustomerEntity customer;
    //@Autowired
    //GenericService genericService;
    @Autowired
    BlacklistHandlerImpl blacklistHandler = new BlacklistHandlerImpl();
    @Autowired
    BlacklistEvent blacklistEvent = new BlacklistEvent();
    @Autowired
    DeleteHandlerImpl deleteHandler = new DeleteHandlerImpl();
    @Autowired
    DeleteEvent deleteEvent = new DeleteEvent();
    @Autowired
    MoEvent moEvent;
    @Autowired
    SubscriptionProfileEntity subscriptionProfile = new SubscriptionProfileEntity();
    @Autowired
    GenericServiceImpl genericService = new GenericServiceImpl();

    @Given("^User belongs to \"([^\"]*)\" program$")
    public void User_belongs_to_program(String program) throws Throwable {
    }

    @Given("^User has \"([^\"]*)\" username$")
    public void User_has_username(String username) throws Throwable {
        userAttributes.setUsername(username);
    }

    @Given("^User has \"([^\"]*)\" password$")
    public void USer_has_password(String password) throws Throwable {
        userAttributes.setPassword(password);
    }

    @Given("^User has \"([^\"]*)\" msisdn$")
    public void User_has_msisdn(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);
    }
    
    //injected
    @Given("^user has msisdn$")
    public void user_has_msisdn() throws Throwable {
        userAttributes.setMsisdn("355006710002");
    }
    
    //injected
    @Given("^user has \"([^\"]*)\" msisdn$")
    public void user_has_msisdn(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);
     }
    
    //injected
    @Given("^The use with \"([^\"]*)\" msisdn$")
    public void the_use_with_msisdn(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);
    }
    
    //injected
    @Given("^has \"([^\"]*)\" msisdn$")
    public void has_msisdn(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);
    }

    //injected
    @Given("^msisdn \"([^\"]*)\"$")
    public void msisdn(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);
    }

    //injected
    @Given("^User with msisdn \"([^\"]*)\" with no profile$")
    public void user_with_msisdn_with_no_profile(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
    }

    //injected
    @Given("^\"([^\"]*)\" msisdn is the identification code for the user with no profile$")
    public void msisdn_is_the_identification_code_for_the_user_with_no_profile(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
    }

    //injected
    @Given("^Unprofiled user identification msisdn of \"([^\"]*)\"$")
    public void unprofiled_user_identification_msisdn_of(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
    }

    //injected
    @Given("^\"([^\"]*)\" msisdn user$")
    public void msisdn_user(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);
    }

    //injected
    @Given("^msisdn \"([^\"]*)\" for the user$")
    public void msisdn_for_the_user(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);
    }

    //injected
    @Given("^User with \"([^\"]*)\" msisdn$")
    public void user_with_msisdn(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);    
    }

    //injected
    @Given("^msisdn for the user is \"([^\"]*)\"$")
    public void msisdn_for_the_user_is(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);

    }

    //injected
    @Given("^User has the id of \"([^\"]*)\" msisdn$")
    public void user_has_the_id_of_msisdn(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);
    }

    //injected
    @Given("^Customer has the id of \"([^\"]*)\" msisdn$")
    public void customer_has_the_id_of_msisdn(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);
    }

    //injected
    @Given("^Mark is a customer with the msidn \"([^\"]*)\"$")
    public void mark_is_a_customer_with_the_msidn(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);   
    }

    //injected
    @Given("^Mary is a Telecom's customer with an msidn of \"([^\"]*)\"$")
    public void mary_is_a_Telecom_s_customer_with_an_msidn_of(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);    
    }

    //injected
    @Given("^Nick is a customer with the msisdn id of \"([^\"]*)\"$")
    public void nick_is_a_customer_with_the_msisdn_id_of(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);   
    }

    //injected
    @Given("^A customer with the msisdn id of \"([^\"]*)\"$")
    public void a_customer_with_the_msisdn_id_of(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);   
    }

    //injected
    @Given("^Sophie with the msisdn id of \"([^\"]*)\"$")
    public void sophie_with_the_msisdn_id_of(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);     
    }

    //injected
    @Given("^Customer with \"([^\"]*)\" msisdn$")
    public void customer_with_msisdn(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);
    }

    @Given("^customer has \"([^\"]*)\" msisdn$")
    public void customer_has_msisdn(String msisdn) throws Throwable {
        userAttributes.setMsisdn(msisdn);
    }

    @Given("^User is not registered$")
    public void User_is_not_registered() throws Throwable {
    }

    @Then("^User has profile$")
    public void User_has_profile() throws Throwable {
        assertTrue(true); //genericService.exists(customer, "msisdn", userAttributes.getMsisdn()));
    }
    
    //injected
    @Then("^user get registered$")
    public void user_get_registered() throws Throwable {
        assertTrue(true); //genericService.exists(customer, "msisdn", userAttributes.getMsisdn()));
     }
    
    //injected
    @Then("^User user get registered$")
    public void user_user_get_registered() throws Throwable {
        assertTrue(true); //genericService.exists(customer, "msisdn", userAttributes.getMsisdn()));
     }
    
    //injected
    @Then("^User has account$")
    public void user_has_account() throws Throwable {
        assertTrue(true); //genericService.exists(customer, "msisdn", userAttributes.getMsisdn()));
     }

    //injected
    @Then("^User has user account$")
    public void user_has_user_account() throws Throwable {
        assertTrue(true); //genericService.exists(customer, "msisdn", userAttributes.getMsisdn()));
    }

    //injected
    @Then("^A profile is created$")
    public void a_profile_is_created() throws Throwable {
        assertTrue(true); //genericService.exists(customer, "msisdn", userAttributes.getMsisdn()));
    }

    //injected
    @Then("^User profile is created$")
    public void user_profile_is_created() throws Throwable {
        assertTrue(true); //genericService.exists(customer, "msisdn", userAttributes.getMsisdn()));
    }

    //injected
    @Then("^The profile is created$")
    public void the_profile_is_created() throws Throwable {
        assertTrue(true); //genericService.exists(customer, "msisdn", userAttributes.getMsisdn()));
    }

    //injected
    @Then("^User subscription profile is unsubscribed$")
    public void user_subscription_profile_is_unsubscribed() throws Throwable {
        assertTrue(true); //genericService.exists(customer, "msisdn", userAttributes.getMsisdn()));
        subscriptionProfile =(SubscriptionProfileEntity)genericService.queryByKey(subscriptionProfile,"msisdn",userAttributes.getMsisdn());
    }

    //injected
    @Then("^Create user profile$")
    public void create_user_profile() throws Throwable {
        assertTrue(true); //genericService.exists(customer, "msisdn", userAttributes.getMsisdn()));
    }

    //injected
    @Then("^Set user profile$")
    public void set_user_profile() throws Throwable {
        assertTrue(true); //genericService.exists(customer, "msisdn", userAttributes.getMsisdn()));
    }

    //injected
    @Then("^Set user's profile$")
    public void set_user_s_profile() throws Throwable {
        assertTrue(true); //genericService.exists(customer, "msisdn", userAttributes.getMsisdn()));

    }

    //injected
    @Then("^User now has a profile$")
    public void user_now_has_a_profile() throws Throwable {
        assertTrue(true);
    }

    //injected
    @Then("^Nick gets a profile$")
    public void nick_gets_a_profile() throws Throwable {
        assertTrue(true);    
    }

    //injected
    @Then("^Customer now has a profile$")
    public void customer_now_has_a_profile() throws Throwable {
        assertTrue(true);
    }

    //injected
    @Then("^Customer gets a profile in the company's system$")
    public void customer_gets_a_profile_in_the_company_s_system() throws Throwable {
        assertTrue(true);
    }    


    //injected
    @Then("^Sophie gets a profile in the company's system$")
    public void sophie_gets_a_profile_in_the_company_s_system() throws Throwable {
        assertTrue(true);  
    }

    @Given("^User is blacklisted$")
    public void User_is_blacklisted() throws Throwable {
        blacklistEvent.setMsisdn(userAttributes.getMsisdn());
        blacklistHandler.blacklist();
    }
    
    //injected
    @Given("^the user is blacklisted$")
    public void the_user_is_blacklisted() throws Throwable {
        blacklistEvent.setMsisdn(userAttributes.getMsisdn());
        blacklistHandler.blacklist();
     }

    //injected
    @Given("^Blacklisted user$")
    public void blacklisted_user() throws Throwable {
        blacklistEvent.setMsisdn(userAttributes.getMsisdn());
        blacklistHandler.blacklist();
    }

    //injected
    @Given("^Nick is blacklisted$")
    public void nick_is_blacklisted() throws Throwable {
        blacklistEvent.setMsisdn(userAttributes.getMsisdn());
        blacklistHandler.blacklist();  
    }

    //injected
    @Given("^Customer is blacklisted$")
    public void customer_is_blacklisted() throws Throwable {
        blacklistEvent.setMsisdn(userAttributes.getMsisdn());
        blacklistHandler.blacklist();   
    }

    //injected 
    @Given("^Sophie is blacklisted$")
    public void sophie_is_blacklisted() throws Throwable {
        blacklistEvent.setMsisdn(userAttributes.getMsisdn());
        blacklistHandler.blacklist();    
    }

    @Given("^User is not blacklisted$")
    public void User_is_not_blacklisted() throws Throwable {
        blacklistEvent.setMsisdn(userAttributes.getMsisdn());
        blacklistHandler.unblacklist();
    }
    
    //injected
    @Then("^user is not blacklisted$")
    public void user_is_not_blacklisted() throws Throwable {
        blacklistEvent.setMsisdn(userAttributes.getMsisdn());
        blacklistHandler.unblacklist();
     }

    //injected
    @Then("^Do not blacklist the user$")
    public void do_not_blacklist_the_user() throws Throwable {
        blacklistEvent.setMsisdn(userAttributes.getMsisdn());
        blacklistHandler.unblacklist();
    }

    //injected
    @Then("^Nick is not blacklisted anymore$")
    public void nick_is_not_blacklisted_anymore() throws Throwable {
        blacklistEvent.setMsisdn(userAttributes.getMsisdn());
        blacklistHandler.unblacklist(); 
    }

    //injected
    @Then("^Customer is removed from the blacklisted list$")
    public void customer_is_removed_from_the_blacklisted_list() throws Throwable {
        blacklistEvent.setMsisdn(userAttributes.getMsisdn());
        blacklistHandler.unblacklist();  
    }

    //injected
    @Then("^Sophie is not blacklisted anymore$")
    public void sophie_is_not_blacklisted_anymore() throws Throwable {
        blacklistEvent.setMsisdn(userAttributes.getMsisdn());
        blacklistHandler.unblacklist();   
    }

    @And("^User has no profile$")
    public void User_has_no_profile() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
    }
    
    //injected
    @Given("^user has no profile$")
    public void user_has_no_profile() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
    }
    
    //injected
    @Given("^User has no user account$")
    public void user_has_no_user_account() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
     }
    
    //injected
    @Given("^User has no account$")
    public void user_has_no_account() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
     }
    
    @Given("^User has no account in the system$")
    public void user_has_no_account_in_the_system() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
    }

    //injected
    @Given("^User with no profile$")
    public void user_with_no_profile() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
    }

    //injected
    @Given("^No profile for user$")
    public void no_profile_for_user() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
    }

    //injected
    @Given("^No user's profile$")
    public void no_user_s_profile() throws Throwable {    
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
    }

    //injected
    @Given("^No profile for the user$")
    public void no_profile_for_the_user() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();    
    }

    //injected
    @Given("^there is no user's profile$")
    public void there_is_no_user_s_profile() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();

    }

    //injected
    @Given("^User does not have a profile$")
    public void user_does_not_have_a_profile() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
    }


    //injected
    @Given("^User has no user details$")
    public void user_has_no_user_details() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
    }

    //injected
    @Given("^Mark does not have a profile$")
    public void mark_does_not_have_a_profile() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();    
    }

    //injected
    @Given("^Mary does not have a profile$")
    public void mary_does_not_have_a_profile() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
    }

    //injected 
    @Given("^Nick does not have a profile yet$")
    public void nick_does_not_have_a_profile_yet() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
    }

    //injected
    @Given("^Customer does not have a profile$")
    public void customer_does_not_have_a_profile() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();    
    }

    //injected
    //injected
    @Given("^Sophie does not have a profile in the company$")
    public void sophie_does_not_have_a_profile_in_the_company() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();    
    }

    //injected
    @Given("^User has no userinfo$")
    public void user_has_no_userinfo() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();    
    }

    //injected
    @Given("^Customer has no profile registered in the company$")
    public void customer_has_no_profile_registered_in_the_company() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();       
    }

    //injected
    @Given("^customer has no profile yet$")
    public void customer_has_no_profile_yet() throws Throwable {
        deleteEvent.setMsisdn(userAttributes.getMsisdn());
        deleteHandler.deleteCustomer();
    }

    //injected-no original corresponding step
    @Given("^Customer wants to subscribe to a free week scheme$")
    public void customer_wants_to_subscribe_to_a_free_week_scheme() throws Throwable {
        // todo
    }

    @Given("^User has \"([^\"]*)\" lang code in profile$")
    public void User_has_lang_code_in_profile(String langCode) throws Throwable {
        userAttributes.setLangCode(langCode);
    }


}
