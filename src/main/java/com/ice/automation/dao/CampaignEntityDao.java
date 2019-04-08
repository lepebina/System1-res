package com.ice.automation.dao;

import com.ice.automation.model.cfg.CampaignEntity;


public interface CampaignEntityDao extends GenericEntityDao<CampaignEntity> {

    CampaignEntity getCampaignConfiguration();

    void deleteCampaigns();
}
