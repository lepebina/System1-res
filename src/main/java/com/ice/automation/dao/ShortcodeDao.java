package com.ice.automation.dao;

import com.ice.automation.model.cfg.ShortcodeEntity;


public interface ShortcodeDao {

    ShortcodeEntity getShortcode(String operator, String countryCode, String shortcode);
}
