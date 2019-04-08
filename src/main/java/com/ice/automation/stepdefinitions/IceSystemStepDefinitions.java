package com.ice.automation.stepdefinitions;

import com.ice.automation.cache.SystemAttributes;
import com.ice.automation.events.refresh.RefreshHandler;
import com.ice.automation.events.refresh.impl.RefreshHandlerImpl;
import com.ice.automation.events.time.offset.TimeOffsetEvent;
import com.ice.automation.events.time.offset.impl.TimeOffsetHandlerImpl;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertNotNull;
import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;


public class IceSystemStepDefinitions {

    //@Autowired
    SystemAttributes systemAttributes =new SystemAttributes();

    @Autowired
    TimeOffsetEvent timeOffsetEvent = new TimeOffsetEvent();

    @Autowired
    TimeOffsetHandlerImpl timeOffsetHandler = new TimeOffsetHandlerImpl();

    @Autowired
    RefreshHandlerImpl refreshHandler = new RefreshHandlerImpl();

    @Given("^User belongs to operator \"([^\"]*)\"$")
    public void User_belongs_to_operator(String operator) throws Throwable {
        systemAttributes.setOperator(operator);
    }

    @Given("^Sms free short code is \"([^\"]*)\"$")
    public void Sms_free_short_code_is(String shortcode) throws Throwable {
        assertNotNull(systemAttributes);
        systemAttributes.setFreeShortcode(shortcode);
    }

    @Given("^Sms billed short code is \"([^\"]*)\"$")
    public void Sms_billed_short_code_is(String shortcode) throws Throwable {
        systemAttributes.setBilledShortcode(shortcode);
    }

    @Given("^Sms free subscription short code is \"([^\"]*)\"$")
    public void Sms_free_subscription_short_code_is(String shortcode) throws Throwable {
        systemAttributes.setSubscriptionFreeShortcode(shortcode);
    }

    @Given("^Sms billed subscription short code is \"([^\"]*)\"$")
    public void Sms_billed_subscription_short_code_is(String shortcode) throws Throwable {
        systemAttributes.setSubscriptionBilledShortcode(shortcode);
    }

    @Given("^System has offset \"([^\"]*)\"$")
    public void System_has_offset(String offset) throws Throwable {
        systemAttributes.setOffset(offset);
    }

    @Given("^Refresh cache$")
    public void Refresh_cache() throws Throwable {
        refreshHandler.refreshCache();
    }
    
    //injected
    @Given("^Someone refresshes the cache of the system$")
    public void someone_refresshes_the_cache_of_the_system() throws Throwable {
        refreshHandler.refreshCache();    
    }
    
    //injected
    @Given("^Someone refreshes the cache of the system$")
    public void someone_refreshes_the_cache_of_the_system() throws Throwable {   
        refreshHandler.refreshCache();
    }


    @Given("^Current time is \"([^\"]*)\"$")
    public void Current_time_is(String timeInHours) throws UnsupportedEncodingException {
        if (timeInHours.equals("0")) {
            timeOffsetEvent.setOffSetInMillies(timeInHours);
            timeOffsetHandler.sendDefaultApi();
        } else {
            long millis = Long.parseLong(timeInHours) * 60 * 60 * 1000 - Long.parseLong(timeInHours) * 60 * 60 * 1000 * 2;
            timeOffsetEvent.setOffSetInMillies(String.valueOf(millis));
            timeOffsetHandler.sendDefaultApi();
        }
    } 
    
    //injected
    @Then("^update current time to \"([^\"]*)\"$")
    public void update_current_time_to(String timeInHours) throws Throwable {
        if (timeInHours.equals("0")) {
            timeOffsetEvent.setOffSetInMillies(timeInHours);
            timeOffsetHandler.sendDefaultApi();
        } else {
            long millis = Long.parseLong(timeInHours) * 60 * 60 * 1000 - Long.parseLong(timeInHours) * 60 * 60 * 1000 * 2;
            timeOffsetEvent.setOffSetInMillies(String.valueOf(millis));
            timeOffsetHandler.sendDefaultApi();
        }
     }
    
    //injected
    @Given("^User current time is \"([^\"]*)\"$")
    public void user_current_time_is(String timeInHours) throws Throwable {
        if (timeInHours.equals("0")) {
            timeOffsetEvent.setOffSetInMillies(timeInHours);
            timeOffsetHandler.sendDefaultApi();
        } else {
            long millis = Long.parseLong(timeInHours) * 60 * 60 * 1000 - Long.parseLong(timeInHours) * 60 * 60 * 1000 * 2;
            timeOffsetEvent.setOffSetInMillies(String.valueOf(millis));
            timeOffsetHandler.sendDefaultApi();
        }
     }
    
    //injected
    @Given("^\"([^\"]*)\" current time$")
    public void current_time(String timeInHours) throws Throwable {
        if (timeInHours.equals("0")) {
            timeOffsetEvent.setOffSetInMillies(timeInHours);
            timeOffsetHandler.sendDefaultApi();
        } else {
            long millis = Long.parseLong(timeInHours) * 60 * 60 * 1000 - Long.parseLong(timeInHours) * 60 * 60 * 1000 * 2;
            timeOffsetEvent.setOffSetInMillies(String.valueOf(millis));
            timeOffsetHandler.sendDefaultApi();
        }
     }

    @And("^Wait for \"([^\"]*)\"s$")
    public void Wait_for_s(String seconds) throws Throwable {
        Thread.sleep(Long.parseLong(seconds) * 10);
    }

    @Given("^Create base bulk file with the following msisdns$")
    public void Create_base_bulk_file_with_the_following_msisdns(DataTable msisdns) throws Throwable {

        File temp = new File(System.getProperty("${user.home}")+"msisdsn.txt");
        temp.setWritable(true);
        PrintStream fileWriter = new PrintStream(temp);
        for (int i=0;i<msisdns.getGherkinRows().size();i++) {
            System.out.println(msisdns.getGherkinRows().get(i).getCells().get(0));
            fileWriter.println(msisdns.getGherkinRows().get(i).getCells().get(0));
        }
        fileWriter.close();
    }

}
