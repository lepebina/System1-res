package com.ice.automation.events.keywordconfiguration;

import org.springframework.stereotype.Component;

@Component
public class KeywordAlias {

    String alias;
    String regex;

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
}
