package com.ice.automation.stepdefinitions;

import com.ice.automation.dao.impl.AchievementEntityDaoImpl;
import com.ice.automation.events.achievement.AchievementEvent;
import com.ice.automation.events.achievement.impl.AchievementEventHandlerImpl;
import com.ice.automation.events.refresh.impl.RefreshHandlerImpl;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;


public class IceAchievementStepDefinitions {

    @Autowired
    AchievementEvent achievementEvent;
    @Autowired
    AchievementEventHandlerImpl achievementEventHandler;
    @Autowired
    RefreshHandlerImpl refreshHandler;
    @Autowired
    AchievementEntityDaoImpl achievementEntityDaol;

    @Given("^Create achievement \"([^\"]*)\" with \"([^\"]*)\" prize, \"([^\"]*)\" langcode, \"([^\"]*)\" text key, \"([^\"]*)\" content and \"([^\"]*)\" condition$")
    public void Create_achievement_with_langcode_text_key_and_content(String achieveName, String prize, String lang, String textKey, String content, String condition) throws Throwable {
        achievementEvent.setPrize(prize);
        achievementEvent.setLanguage(lang);
        achievementEvent.setContent(content);
        achievementEvent.setTextKey(textKey);
        achievementEvent.setAchievementName(achieveName);
        achievementEvent.setCondition(condition);

        achievementEventHandler.createAchievement();
        refreshHandler.refreshCache();

    }

    @And("^Clear achievement \"([^\"]*)\" from DB$")
    public void Clear_achievement_from_DB(String achievementNAme) throws Throwable {
        achievementEntityDaol.deleteAchievement(achievementNAme);
    }
}
