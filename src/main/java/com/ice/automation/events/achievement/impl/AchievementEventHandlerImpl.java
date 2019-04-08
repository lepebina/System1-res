package com.ice.automation.events.achievement.impl;

import com.ice.automation.drivers.clients.RestClient;
import com.ice.automation.events.achievement.AchievementEvent;
import com.ice.automation.events.achievement.AchievementEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;


@Service("achievementEventHandlerImpl")
public class AchievementEventHandlerImpl implements AchievementEventHandler {
    RestClient restClient = new RestClient();

    @Autowired
    AchievementEvent achievementEvent;

    @Value("#{properties['server_host']}")
    private String host;
    @Value("#{properties['server_port']}")
    private String port;

    String enc= WebUtils.DEFAULT_CHARACTER_ENCODING;

    private String getUrl() {
        return String.format("http://%s:%s/%s",
                host,
                port,
                achievementEvent.getApiUrl());
    }


    @Override
    public String createAchievement() throws UnsupportedEncodingException {
        return restClient.put(UriUtils.encodeQuery(getUrl(), enc), achievementEvent.getJsonObject()).toString();
    }

    @Override
    public String editAchievement() throws UnsupportedEncodingException {
        return restClient.post(UriUtils.encodeQuery(getUrl(), enc), achievementEvent.getJsonObject()).toString();

    }

    @Override
    public void initApiParam() {
    }
}
