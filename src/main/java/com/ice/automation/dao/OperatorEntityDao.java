package com.ice.automation.dao;

import com.ice.automation.model.cfg.CampaignEntity;
import com.ice.automation.model.cfg.OperatorEntity;


public interface OperatorEntityDao extends GenericEntityDao<OperatorEntity> {

    void deleteOperators();

    void deleteShortcodes();
}
