package com.ice.automation.events.achievement;

import org.springframework.stereotype.Component;


@Component
public class AchievementEvent {

    String apiUrl;
    String actionServiceName = null;
    String conditionValidationService=null;
    String prize;
    String textKey;
    String language;
    String content;
    private String achievementName;
    private String condition;

    public String getActionServiceName() {
        return actionServiceName;
    }

    public void setActionServiceName(String actionServiceName) {
        this.actionServiceName = actionServiceName;
    }

    public String getConditionValidationService() {
        return conditionValidationService;
    }

    public void setConditionValidationService(String conditionValidationService) {
        this.conditionValidationService = conditionValidationService;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getTextKey() {
        return textKey;
    }

    public void setTextKey(String textKey) {
        this.textKey = textKey;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setJsonObject(String jsonObject) {
        this.jsonObject = jsonObject;
    }

    String jsonObject = "{\n" +
            "  \"name\":\"%s\",\n" +
            "  \"condition\":\"%s\",\n" +
            "  \"actionServiceName\":\"provisionOfferActionHandler\",\n" +
            "  \"conditionValidationService\":\"every15ContentDeliveriesConditionValidator\",\n" +
            "  \"prize\":\"%s\",\n" +
            "  \"obtainedText\":{\n" +
            "  \"key\":\"%s\",\n" +
            "     \"texts\":[\n" +
            "        {\n" +
            "           \"language\":\"%s\",\n" +
            "           \"content\":\"%s\"\n" +
            "        }\n" +
            "     ]\n" +
            "  }\n" +
            "}\n";

    public String getJsonObject() {
        return String.format(this.jsonObject, this.getAchievementName(),this.getCondition(),this.getPrize(), this.getTextKey(), this.getLanguage(), this.getContent());
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiUrl() {

        if (apiUrl == null) {
            apiUrl = "ice-app/api/achievements";
        }
        return apiUrl;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }
}
