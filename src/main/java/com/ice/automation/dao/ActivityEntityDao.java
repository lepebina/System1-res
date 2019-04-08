package com.ice.automation.dao;

//import com.ice.automation.model.activity.ActivityEntity;

import com.ice.automation.model.activity.ActivityEntity;


public interface ActivityEntityDao {

    ActivityEntity getActivityById(long activityId);
}
