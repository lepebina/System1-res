package com.ice.automation.events.message;

import org.springframework.stereotype.Component;


@Component
public class MessageEvent {
    String message;
    String langode;

    String finalJson = "{\n" +
            "\n" +
            "  \"texts\":[{\n" +
            "\n" +
            "    \"language\":\"%s\",\n" +
            "\n" +
            "    \"content\":\"%s\"\n" +
            "\n" +
            "  }]\n" +
            "\n" +
            "}";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLangode() {
        return langode;
    }

    public void setLangode(String langode) {
        this.langode = langode;
    }

    public String getFinalJson() {
        return String.format(this.finalJson,this.getLangode(),this.getMessage());
    }

    public void setFinalJson(String finalJson) {
        this.finalJson = finalJson;
    }
}
