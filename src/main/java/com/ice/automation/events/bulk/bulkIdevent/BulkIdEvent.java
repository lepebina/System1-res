package com.ice.automation.events.bulk.bulkIdevent;

import org.springframework.stereotype.Component;

@Component
public class BulkIdEvent {
    String apiUrl;

    String jsonObject = "{\n" +
            "  \"id\": %s,\n" +
            "  \"name\": \"%s\",\n" +
            "  \"segmentName\": \"%s\",\n" +
            "  \"startDate\": \"%s 00:00:00\",\n" +
            "  \"endDate\": \"%s 00:00:00\",\n" +
            "  \"subscriptionId\": %s,\n" +
            "  \"executorName\": \"%s\",\n" +
            "  \"triggerName\": \"%s\",\n" +
//            "  \"shortcode\": \"%s\",\n" +
            "  \"staticTextKey\": \"%s\",\n" +
            "  \"dynamicTextRuleId\": %s\n" +
            "}\n";
    String id;
    String name;
    String segmentSql;
    String startDate;
    String endDate;
    String subscriptionId;
    String executorName;
    String staticTextKey;
    String dynamicTextRuleId;
    private String triggerName;
    private String shortcode;

    public String getJsonObject() {
        return String.format( jsonObject ,
                this.getId(),
                this.getName(),
                this.getSegmentSql(),
                this.getStartDate(),
                this.getEndDate(),
                this.subscriptionId,
                this.getExecutorName(),
                this.getTriggerName(),
//                this.getShortcode(),
                this.getStaticTextKey(),
                this.getDynamicTextRuleId());
    }

    public void setJsonObject(String jsonObject) {
        this.jsonObject = jsonObject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSegmentSql() {
        return segmentSql;
    }

    public void setSegmentSql(String segmentSql) {
        this.segmentSql = segmentSql;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getExecutorName() {
        return executorName;
    }

    public void setExecutorName(String executorName) {
        this.executorName = executorName;
    }

    public String getStaticTextKey() {
        return staticTextKey;
    }

    public void setStaticTextKey(String staticTextKey) {
        this.staticTextKey = staticTextKey;
    }

    public String getDynamicTextRuleId() {
        return dynamicTextRuleId;
    }

    public void setDynamicTextRuleId(String dynamicTextRuleId) {
        this.dynamicTextRuleId = dynamicTextRuleId;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiUrl() {
        if (apiUrl == null) {
            apiUrl = "ice-app/api/bulk";
        }
        return apiUrl;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public String getShortcode() {
        return shortcode;
    }
}