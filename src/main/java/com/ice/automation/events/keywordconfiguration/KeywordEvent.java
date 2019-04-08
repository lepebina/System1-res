package com.ice.automation.events.keywordconfiguration;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class KeywordEvent {
	String apiUrl;
	String name;
    String keywordService;
    String subscriptionName;
    String alias;
    String regex;
    String operator;
    String countryCode;
    String shortcode;

    Set<KeywordAlias> aliases = new HashSet<KeywordAlias>();
    Set<KeywordConfiguration> configurations = new HashSet<KeywordConfiguration>();

    String jsonObject = "{\n" +
            "  \"name\": \"%s\",\n" +
            "  \"keywordService\": \"%s\",\n" +
            "  \"subscriptionName\": \"%s\",\n" +
            "  \"aliases\": [\n" +
            "    {\n" +
            "      \"alias\": \"%s\",\n" +
            "      \"regex\": %s,\n" +
            "    }\n" +
            "  ]\n" +
            "  \"configurations\": [\n" +
            "    {\n" +
            "      \"operator\": \"%s\",\n" +
            "      \"countryCode\": %s,\n" +
            "      \"shortcode\": %s,\n" +
            "    }\n" +
            "  ]\n" +
            "}\n";

    public String getJsonObject() {
        return String.format(this.jsonObject,this.getName(),
                this.keywordService,
                this.getSubscriptionName(),
                this.getAlias(),
                this.getRegex(),
                this.getOperator(),
                this.getCountryCode(),
                this.getShortcode());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywordService() {
        return keywordService;
    }

    public void setKeywordService(String keywordService) {
        this.keywordService = keywordService;
    }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    public Set<KeywordAlias> getAliases() {
        return aliases;
    }

    public void setAliases(Set<KeywordAlias> aliases) {
        this.aliases = aliases;
    }

    public Set<KeywordConfiguration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(Set<KeywordConfiguration> configurations) {
        this.configurations = configurations;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public void setJsonObject(String jsonObject) {
        this.jsonObject = jsonObject;
    }

    public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getApiUrl() {
		if (apiUrl == null) {
			apiUrl = "ice-app/api/config/keyword";
		}
		return apiUrl;
	}
}