package com.ice.automation.stepdefinitions;

import com.ice.automation.commons.router.Channel;
import com.ice.automation.drivers.browsers.BrowserDriver;
import com.ice.automation.commons.GenericService;
import com.ice.automation.model.router.IncomingMessage;
import com.ice.automation.model.router.OutGoingMessage;
import com.ice.automation.ui.actions.GoogleSearchPageActions;
import com.ice.automation.ui.pagecontrollers.impl.GenericPageControllerImpl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;


public class IceStepDefinitions {

    @Autowired
    BrowserDriver browserDriver;
    @Autowired
    GenericPageControllerImpl genericPageController;
    @Autowired
    GoogleSearchPageActions googleSearchPageActions;
    @Autowired
    IncomingMessage mo;
    @Autowired
    GenericService genericService;
    @Autowired
    OutGoingMessage mt;

    @Given("^I'm using browser \"([^\"]*)\"$")
    public void I_m_using_browser(String browser) throws Throwable {
//        InitialCachedData initialCachedData = (InitialCachedData) cachedDataContext.getObject("initialCachedData");
        //       initialCachedData.setBrowser(Browsers.getBrowserForName(browser));
        genericPageController.initializeElementsForAllPages();
    }

    @Given("^I'm at google home page$")
    public void I_at_google_home_page() throws Throwable {
        browserDriver.loadPage("http://www.google.com");
    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String searchArgument) throws Throwable {
        googleSearchPageActions.searchFor(searchArgument);
    }

    @When("^I go to page \"([^\"]*)\"$")
    public void I_go_to_page(String url) throws Throwable {
        browserDriver.loadPage(url);

    }

    @When("^I send a mo")
    public void I_create_an_mo() throws Throwable {
        mo.setChannel(Channel.SMS);
        mo.setCostWeight(1.5);
        mo.setMessageId("12345678");
        mo.setSender("6972033763");
        mo.setRequestType("register");
        genericService.persist(mo);
    }

    @Then("^I get an mo$")
    public void I_get_an_mo() throws Throwable {
        IncomingMessage incomingMessage = (IncomingMessage) genericService.queryByKey(mo, "messageId", "12345678");
        Assert.assertEquals("6972033763", incomingMessage.getSender());
    }




}
