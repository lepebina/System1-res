package com.ice.automation.events.achievement;

import java.io.UnsupportedEncodingException;


public interface AchievementEventHandler {

    public String createAchievement() throws UnsupportedEncodingException;

    public String editAchievement() throws UnsupportedEncodingException;

    public void initApiParam() ;
}
