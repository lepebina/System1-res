package com.ice.automation.stepdefinitions;

import com.ice.automation.dao.BulkEntityDao;
import com.ice.automation.dao.BulkTriggerEntityDao;
import com.ice.automation.events.blacklist.BlacklistEvent;
import com.ice.automation.events.blacklist.BlacklistHandler;
import com.ice.automation.events.blacklist.impl.BlacklistHandlerImpl;
import com.ice.automation.events.bulk.bulkIdevent.BulkIdEvent;
import com.ice.automation.events.bulk.bulkIdevent.impl.BulkIdHandlerImpl;
import com.ice.automation.events.bulk.bulkdetails.impl.BulkIdDetailsHandlerImpl;
import com.ice.automation.events.bulk.start.startevent.StartEvent;
import com.ice.automation.events.bulk.start.startevent.impl.StartHandlerImpl;
import com.ice.automation.events.refresh.impl.RefreshHandlerImpl;
import com.ice.automation.events.trigger.triggerdetails.impl.TriggerDetailsHandlerImpl;
import com.ice.automation.events.trigger.triggeridevent.TriggeridEvent;
import com.ice.automation.events.trigger.triggeridevent.impl.TriggeridHandlerImpl;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;


public class IceTriggerStepDefinitions {
    @Autowired
    TriggeridEvent triggerIdEvent;
    @Autowired
    TriggeridHandlerImpl triggerIdHandlerImpl;

    @Autowired
    BulkIdEvent bulkIdEvent;
    @Autowired
    BulkIdHandlerImpl bulkIdHandler;

    @Autowired
    TriggerDetailsHandlerImpl triggerDetailsHandlerImpl;
    @Autowired
    BulkIdDetailsHandlerImpl bulkIdDetailsHandler;
    @Autowired
    StartHandlerImpl startHandler = new StartHandlerImpl();
    @Autowired
    StartEvent startEvent = new StartEvent();
    @Autowired
    RefreshHandlerImpl refreshHandler;
    @Autowired
    BulkEntityDao bulkEntityDao;
    @Autowired
    BulkTriggerEntityDao bulkTriggerEntityDao;

    @Autowired
    BlacklistHandlerImpl blacklistHandler =new BlacklistHandlerImpl();
    @Autowired
    BlacklistEvent blacklistEvent = new BlacklistEvent();


    @Given("^Create trigger with id \"([^\"]*)\" , name \"([^\"]*)\" and schedule time \"([^\"]*)\"$")
    public void Create_trigger_with_id_name_and_schedule_time(String id, String name, String cron) throws Throwable {
        triggerIdEvent.setId(id);
        triggerIdEvent.setName(name);
        triggerIdEvent.setCron(cron);

        triggerIdHandlerImpl.sendDefaultApi();
        refreshHandler.refreshCache();

    }

    @Then("^Trigger is configured$")
    public void Trigger_configured() throws Throwable {
        //TODO: validation through DB
    }

    @Given("^Create bulk with the following details:$")
    public void Create_bulk_with_the_following_details(DataTable configuration) throws Throwable {
        bulkIdEvent.setId(configuration.getGherkinRows().get(1).getCells().get(0));
        bulkIdEvent.setName(configuration.getGherkinRows().get(1).getCells().get(1));
        bulkIdEvent.setSegmentSql(configuration.getGherkinRows().get(1).getCells().get(2));
        bulkIdEvent.setStartDate(configuration.getGherkinRows().get(1).getCells().get(3));
        bulkIdEvent.setEndDate(configuration.getGherkinRows().get(1).getCells().get(4));
        bulkIdEvent.setSubscriptionId(configuration.getGherkinRows().get(1).getCells().get(5));
        bulkIdEvent.setExecutorName(configuration.getGherkinRows().get(1).getCells().get(6));
        bulkIdEvent.setTriggerName(configuration.getGherkinRows().get(1).getCells().get(7));
        bulkIdEvent.setShortcode(configuration.getGherkinRows().get(1).getCells().get(8));
        bulkIdEvent.setStaticTextKey(configuration.getGherkinRows().get(1).getCells().get(9));
        bulkIdEvent.setDynamicTextRuleId(configuration.getGherkinRows().get(1).getCells().get(10));

        bulkIdHandler.createBulk();
        refreshHandler.refreshCache();

    }

    @Then("^Retrieve trigger details$")
    public void Retrieve_trigger_details() throws Throwable {
        triggerDetailsHandlerImpl.sendDefaultApi();
    }

    @Then("^Retrieve bulk details$")
    public void Retrieve_bulk_details() throws Throwable {
        bulkIdDetailsHandler.sendDefaultApi();
    }

    @Given("^Edit bulk with the following details:$")
    public void Edit_bulk_with_the_following_details(DataTable configuration) throws Throwable {
        //   bulkIdEvent.setId(configuration.getGherkinRows().get(1).getCells().get(0));
        bulkIdEvent.setName(configuration.getGherkinRows().get(1).getCells().get(0));
        bulkIdEvent.setSegmentSql(configuration.getGherkinRows().get(1).getCells().get(1));
        bulkIdEvent.setStartDate(configuration.getGherkinRows().get(1).getCells().get(2));
        bulkIdEvent.setEndDate(configuration.getGherkinRows().get(1).getCells().get(3));
        bulkIdEvent.setSubscriptionId(configuration.getGherkinRows().get(1).getCells().get(4));
        bulkIdEvent.setExecutorName(configuration.getGherkinRows().get(1).getCells().get(5));
        bulkIdEvent.setTriggerName(configuration.getGherkinRows().get(1).getCells().get(6));
        bulkIdEvent.setShortcode(configuration.getGherkinRows().get(1).getCells().get(7));
        bulkIdEvent.setStaticTextKey(configuration.getGherkinRows().get(1).getCells().get(8));


        bulkIdHandler.editBulk();
        refreshHandler.refreshCache();

    }

    @Then("^Bulk is configured$")
    public void Bulk_is_configured() throws Throwable {
        //TODO: validation through DB
    }

    @When("^Bulk \"([^\"]*)\" is triggered$")
    public void Bulk_is_triggered(String bulkName) throws Throwable {
        startEvent.setBulkId(bulkName);
        startHandler.sendDefaultApi();
    }

    @When("^Billing teaser \"([^\"]*)\" is triggered$")
    public void Billing_teaser_is_triggered(String billingTeaserName) throws Throwable {
        startEvent.setBulkId(billingTeaserName);
        startHandler.sendDefaultApi();
    }

    @When("^Freeing teaser \"([^\"]*)\" is triggered$")
    public void Freeing_teaser_is_triggered(String freeingTeaserId) throws Throwable {
        startEvent.setBulkId(freeingTeaserId);
        startHandler.sendDefaultApi();
        //Thread.sleep(5000);
    }
    
    //injected
    @When("^Freeing teaser \"([^\"]*)\" is activated$")
    public void freeing_teaser_is_activated(String freeingTeaserId) throws Throwable {
        startEvent.setBulkId(freeingTeaserId);
        startHandler.sendDefaultApi();
        //Thread.sleep(5000);
    }
    
    //injected
    @When("^Triggering freeing teaser \"([^\"]*)\"$")
    public void triggering_freeing_teaser(String freeingTeaserId) throws Throwable {
        startEvent.setBulkId(freeingTeaserId);
        startHandler.sendDefaultApi();
        //Thread.sleep(5000);
    }

    @And("^Clear trigger \"([^\"]*)\"$")
    public void Clear_trigger(String triggerName) throws Throwable {
        bulkTriggerEntityDao.deleteTrigger(triggerName);

    }

    @And("^Clear base bulk \"([^\"]*)\"$")
    public void Clear_base_bulk(String bulkName) throws Throwable {
        bulkEntityDao.deleteBulk(bulkName);
    }

    @And("^Base bulk users are blacklisted$")
    public void Base_bulk_users_are_blacklisted(DataTable table) throws Throwable {
        for (int i = 0; i < table.getGherkinRows().size(); i++) {
            blacklistEvent.setMsisdn(table.getGherkinRows().get(i).getCells().get(0));
            blacklistHandler.blacklist();
        }
    }
}
