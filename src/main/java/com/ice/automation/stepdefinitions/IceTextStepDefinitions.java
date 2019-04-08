package com.ice.automation.stepdefinitions;

import com.ice.automation.cache.SystemAttributes;
import com.ice.automation.cache.UserAttributes;
import com.ice.automation.commons.GenericService;
import com.ice.automation.commons.GenericServiceImpl;
import com.ice.automation.dao.TextKeyEntityDao;
import com.ice.automation.dao.impl.TextKeyEntityDaoImpl;
import com.ice.automation.events.message.MessageEvent;
import com.ice.automation.events.message.impl.MessageHandlerImpl;
import com.ice.automation.events.refresh.impl.RefreshHandlerImpl;
import com.ice.automation.events.textconfiguration.TextKeyEvent;
import com.ice.automation.events.textconfiguration.impl.SubTextKeyHandlerImpl;
import com.ice.automation.events.textconfiguration.impl.TextKeyHandlerImpl;
import com.ice.automation.model.cfg.LanguageEntity;
import com.ice.automation.model.text.TextContentEntity;
import com.ice.automation.model.text.TextKeyEntity;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;


public class IceTextStepDefinitions {

    @Autowired
    TextKeyHandlerImpl textKeyHandler = new TextKeyHandlerImpl();
    @Autowired
    SubTextKeyHandlerImpl subTextKeyHandler = new SubTextKeyHandlerImpl();
    @Autowired
    TextKeyEvent textKeyEvent = new TextKeyEvent();
    @Autowired
    UserAttributes userAttributes = new  UserAttributes();
    @Autowired
    GenericServiceImpl genericService = new GenericServiceImpl();
    @Autowired
    LanguageEntity languageEntity = new LanguageEntity();
    @Autowired
    RefreshHandlerImpl refreshHandler = new RefreshHandlerImpl();
    @Autowired
    TextKeyEntityDao textKeyEntityDao;
    @Autowired
    SystemAttributes systemAttributes;
    @Autowired
    MessageHandlerImpl messageHandler = new MessageHandlerImpl();
    @Autowired
    MessageEvent messageEvent;

    @When("^Smart field replace call for text key \"([^\"]*)\" is triggered$")
    public void Smart_field_replace_call_for_text_key_is_triggered(String textKey) throws Throwable {
        textKeyEvent.setTextKey(textKey);
        textKeyEvent.setMsisdn(userAttributes.getMsisdn());
       // textKeyEvent.setMsisdn("msisdn");
        textKeyEvent.setLanguage(userAttributes.getLangCode());
        textKeyEvent.setResponse(textKeyHandler.sendDefaultApi());
        refreshHandler.refreshCache();

    }

    @Then("^Smart field has value \"([^\"]*)\"$")
    public void Smart_field_has_value(String smartFieldValue) throws Throwable {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        if (smartFieldValue.equals(TextKeyEvent.smart_field.msisdn))
            Assert.assertTrue(textKeyEvent.getResponse().contains(userAttributes.getMsisdn()));
        else if (smartFieldValue.equals(TextKeyEvent.smart_field.today))
            Assert.assertTrue(textKeyEvent.getResponse().contains(sdf.format(date)));
        else if (smartFieldValue.equals(TextKeyEvent.smart_field.totalCharges))
            Assert.assertTrue(textKeyEvent.getResponse().contains(userAttributes.getTotalCharges()));
    }

    @When("^Smart field replace call for text key \"([^\"]*)\" for subId \"([^\"]*)\" is triggered$")
    public void Smart_field_replace_call_for_text_key_for_subId_is_triggered(String textKey, String subId) throws Throwable {
        textKeyEvent.setTextKey(textKey);
        textKeyEvent.setMsisdn(userAttributes.getMsisdn());
        //textKeyEvent.setMsisdn("msisdn");
        textKeyEvent.setLanguage(userAttributes.getLangCode());
        //textKeyEvent.setLanguage("langcode");
        textKeyEvent.setSubId(subId);
        textKeyEvent.setResponse(subTextKeyHandler.sendDefaultApi());
        refreshHandler.refreshCache();

    }

    @And("^Text key \"([^\"]*)\" with \"([^\"]*)\" content and \"([^\"]*)\" language is created$")
    public void Text_key_with_content_and_language_is_created(String key, String content, String language) throws Throwable {
        TextKeyEntity textKey = new TextKeyEntity();
        textKey.setKey(key);
        languageEntity=(LanguageEntity)genericService.queryByKey(languageEntity, "isoCode", language);
        TextContentEntity textContent = new TextContentEntity();
        textContent.setLanguageEntity(languageEntity);
        textContent.setTextKeyEntity(textKey);
        textContent.setTextLiteral(content);
        textKey.getTextContentEntities().add(textContent);

       // genericService.persist(textKey);
//        messageEvent.setMessage(content);
//        messageEvent.setLangode(language);
//        messageHandler.createMessage();


    }

    @And("^Clear text key \"([^\"]*)\"$")
    public void clearTextKey(String textKeyName) throws Throwable {
        textKeyEvent.setTextKey(textKeyName);
        messageHandler.deleteMessage();

    }
}
