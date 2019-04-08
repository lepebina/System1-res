package com.ice.automation.events.time.offset;

import org.springframework.stereotype.Component;


@Component
public class TimeOffsetEvent {
//    http://localhost:8080/ice-app/api/time/offset?offsetMillies=<OFFSET>

    String apiUrl;
    String offSetInMillies;

    public String getOffSetInMillies() {
        return offSetInMillies;
    }

    public void setOffSetInMillies(String offSetInMillies) {
        this.offSetInMillies = offSetInMillies;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiUrl() {
        if (apiUrl == null) {
            apiUrl = "ice-app/api/time/offset?offsetMillis=%s";
        }
        return apiUrl;
    }

}
