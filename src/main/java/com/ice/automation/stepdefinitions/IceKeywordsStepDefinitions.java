package com.ice.automation.stepdefinitions;

import com.ice.automation.events.keywordconfiguration.KeywordEvent;
import com.ice.automation.events.keywordconfiguration.impl.KeywordHandlerImpl;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;


public class IceKeywordsStepDefinitions {

    @Autowired
    KeywordEvent keyword;
    @Autowired
    KeywordHandlerImpl keywordHandler;

    @Given("^Keyword \"([^\"]*)\"\" has the following details:$")
    public void Keyword_has_the_following_details(String keywordName, DataTable dt) throws Throwable {
        for (int i = 1; i < dt.getGherkinRows().size(); i++) {
            keyword.setName(keywordName);
            keyword.setKeywordService(dt.getGherkinRows().get(i).getCells().get(0));
            keyword.setSubscriptionName(dt.getGherkinRows().get(i).getCells().get(1));
        }
    }

    @Given("^Keyword \"([^\"]*)\" has the below aliases:$")
    public void Keyword_has_the_below_aliases(String keywordName, DataTable dt) throws Throwable {

        for (int i = 1; i < dt.getGherkinRows().size(); i++) {
            keyword.setAlias(dt.getGherkinRows().get(i).getCells().get(0));
            keyword.setRegex(dt.getGherkinRows().get(i).getCells().get(1));
        }
    }

    @Given("^Keyword  \"([^\"]*)\" has the below configuration:$")
    public void Keyword_has_the_below_configuration(String keywordName, DataTable dt) throws Throwable {

        for (int i = 1; i < dt.getGherkinRows().size(); i++) {
            keyword.setOperator(dt.getGherkinRows().get(i).getCells().get(0));
            keyword.setCountryCode(dt.getGherkinRows().get(i).getCells().get(1));
            keyword.setShortcode(dt.getGherkinRows().get(i).getCells().get(2));
        }
    }


    @When("^Keyword \"([^\"]*)\" is created$")
    public void Keyword_is_created(String keywordName) throws Throwable {
       keywordHandler.create();
    }

    @Then("^Keyword \"([^\"]*)\" is configured$")
    public void Keyword_is_configured(String keywordName) throws Throwable {
        //todo add implementation
    }
}
