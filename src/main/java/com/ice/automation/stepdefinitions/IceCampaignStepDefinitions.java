package com.ice.automation.stepdefinitions;

import com.ice.automation.cache.SystemAttributes;
import com.ice.automation.commons.GenericService;
import com.ice.automation.dao.CampaignEntityDao;
import com.ice.automation.events.campaign.CampaignEvent;
import com.ice.automation.events.campaign.impl.CampaignHandlerImpl;

import com.ice.automation.events.operatorconfiguration.OperatorEvent;
import com.ice.automation.events.operatorconfiguration.impl.OperatorHandlerImpl;
import com.ice.automation.events.refresh.impl.RefreshHandlerImpl;
import com.ice.automation.model.cfg.CampaignEntity;
import com.ice.automation.model.cfg.OperatorEntity;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;


public class IceCampaignStepDefinitions {

    @Autowired
    CampaignEvent campaignEvent = new CampaignEvent() ;
    @Autowired
    CampaignHandlerImpl campaignHandlerImpl = new  CampaignHandlerImpl() ;
    @Autowired
    OperatorEvent operatorEvent;
    @Autowired
    OperatorHandlerImpl operatorHandlerImpl;
    @Autowired
    SystemAttributes systemAttributes;
    @Autowired
    CampaignEntityDao campaignEntityDao;
    @Autowired
    GenericService genericService;
    @Autowired
    RefreshHandlerImpl refreshHandler = new RefreshHandlerImpl() ;

    @Given("^Create campaign \"([^\"]*)\" begin on \"([^\"]*)\" and ends on \"([^\"]*)\" with langCode \"([^\"]*)\"$")
    public void Create_campaign_begin_on_and_ends_on_with_langCode(String campaignKey, String startDate, String endDate, String langCode) throws Throwable {
        campaignEvent.setCampaignKey(campaignKey);
        campaignEvent.setEndDate(endDate);
        campaignEvent.setStartDate(startDate);
        campaignEvent.setDefaultLangCode(langCode);

        campaignHandlerImpl.createCampaign();
        //Thread.sleep(2000);
        refreshHandler.refreshCache();
    }

    @Given("^Edit campaign \"([^\"]*)\" begin on \"([^\"]*)\" and ends on \"([^\"]*)\" with langCode \"([^\"]*)\"$")
    public void Edit_campaign_begin_on_and_ends_on_with_langCode(String campaignKey, String startDate, String endDate, String langCode) throws Throwable {
        campaignEvent.setCampaignKey(campaignKey);
        campaignEvent.setEndDate(endDate);
        campaignEvent.setStartDate(startDate);
        campaignEvent.setDefaultLangCode(langCode);

        campaignHandlerImpl.editCampaign();
        //Thread.sleep(2000);
        refreshHandler.refreshCache();

    }
    
    //injected
   
        @Given("^Edit \"([^\"]*)\" begin on \"([^\"]*)\" and ends on \"([^\"]*)\"$")
        public void edit_begin_on_and_ends_on(String campaignKey, String startDate, String endDate) throws Throwable {
            campaignEvent.setCampaignKey(campaignKey);
            campaignEvent.setEndDate(endDate);
            campaignEvent.setStartDate(startDate);
        // Write code here that turns the phrase above into concrete actions
            campaignHandlerImpl.editCampaign();
            //Thread.sleep(2000);
            refreshHandler.refreshCache();
    }
    
    //injected
    @Given("^Edit \"([^\"]*)\" campaign to start on \"([^\"]*)\" and to end on \"([^\"]*)\" with langCode \"([^\"]*)\"$")
    public void edit_campaign_to_start_on_and_to_end_on_with_langCode(String campaignKey, String startDate, String endDate, String langCode) throws Throwable {
        campaignEvent.setCampaignKey(campaignKey);
        campaignEvent.setEndDate(endDate);
        campaignEvent.setStartDate(startDate);
        campaignEvent.setDefaultLangCode(langCode);

        campaignHandlerImpl.editCampaign();
        //Thread.sleep(2000);
        refreshHandler.refreshCache();
    
    }

    @Given("^Create operator \"([^\"]*)\" with \"([^\"]*)\" country code, \"([^\"]*)\" billed short code and msisdn with \"([^\"]*)\" prefix and \"([^\"]*)\" length$")
    public void Create_operator_with_country_code_and_billed_short_code(String operatorName, String countryCode,String msisdnPrefix,String msisdnLength, String shortcode) throws Throwable {
        operatorEvent.setOperatorName(operatorName);
        operatorEvent.setCountryCode(countryCode);
        operatorEvent.setShortcodes(shortcode);
        operatorEvent.setCostWeight("1.0");
        operatorEvent.setType("MO_MT");
        operatorEvent.setMsisdnPrefix(msisdnPrefix);
        operatorEvent.setMsisdnLengthWithoutPrefix(msisdnLength);
        operatorHandlerImpl.createOperator();
        //Thread.sleep(2000);
        refreshHandler.refreshCache();

    }

    @Given("^Create operator \"([^\"]*)\" with \"([^\"]*)\" country code and \"([^\"]*)\" free short code$")
    public void Create_operator_with_country_code_and_free_short_code(String operatorName, String countryCode, String shortcode) throws Throwable {
        operatorEvent.setOperatorName(operatorName);
        operatorEvent.setCountryCode(countryCode);
        operatorEvent.setShortcodes(shortcode);
        operatorEvent.setCostWeight("0.0");
        operatorEvent.setType("MO_MT");

        operatorHandlerImpl.createOperator();
        //Thread.sleep(2000);
        refreshHandler.refreshCache();

    }

    @Given("^Edit operator \"([^\"]*)\" with \"([^\"]*)\" country code and \"([^\"]*)\" billed short code$")
    public void Edit_operator_with_country_code_and_billed_short_code(String operatorName, String countryCode, String shortcode) throws Throwable {
        operatorEvent.setOperatorName(operatorName);
        operatorEvent.setCountryCode(countryCode);
        operatorEvent.setShortcodes(shortcode);
        operatorEvent.setCostWeight("1.0");
        operatorEvent.setType("MO_MT");

        operatorHandlerImpl.editOperator();
        //Thread.sleep(2000);
        refreshHandler.refreshCache();

    }

    @Given("^Edit operator \"([^\"]*)\" with \"([^\"]*)\" country code and \"([^\"]*)\" free short code$")
    public void Edit_operator_with_country_code_and_free_short_code(String operatorName, String countryCode, String shortcode) throws Throwable {
        operatorEvent.setOperatorName(operatorName);
        operatorEvent.setCountryCode(countryCode);
        operatorEvent.setShortcodes(shortcode);
        operatorEvent.setCostWeight("0.0");
        operatorEvent.setType("MO_MT");

        operatorHandlerImpl.editOperator();
        //Thread.sleep(2000);
        refreshHandler.refreshCache();

    }

    @Given("^There is no campaign configured in system$")
    public void There_is_no_campaign_configured_in_system() {
//        this.clearCampaigns();
    }

    private void clearCampaigns() {campaignEntityDao.deleteCampaigns();
    }

    @Given("^There is no operator configured in system$")
    public void There_is_no_operator_configured_in_system() throws Throwable {
        this.clearOperators();
    }

    private void clearOperators() {
        //TODO:create clear script for operators
    }

    @Then("^Campaign configured$")
    public void Campaign_configured() throws Throwable {
        Assert.assertTrue(genericService.exists(CampaignEntity.class, "campaignKey", campaignEvent.getCampaignKey()));
    }

    @Then("^Operator configured$")
    public void Operator_configured() throws Throwable {
        Assert.assertTrue(genericService.exists(OperatorEntity.class, "operatorName", operatorEvent.getOperatorName()));
    }

    @Then("^Campaign not configured$")
    public void Campaign_not_configured() throws Throwable {
        Assert.assertFalse(genericService.exists(CampaignEntity.class, "campaignKey", campaignEvent.getCampaignKey()));
    }

    @Then("^Operator not configured$")
    public void Operator_not_configured() throws Throwable {
        Assert.assertFalse(genericService.exists(OperatorEntity.class, "operatorName", operatorEvent.getOperatorName()));
    }
}
