package com.ice.automation.model.blacklist;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


@Entity  @Component
@Table(name = "blacklist")
public class BlacklistedCustomerEntity {

    @Id
    @Column
    private String msisdn;
    @Column(name = "excluded_from_dialogue")
    private boolean excludedFromDialogue;
    @Column(name = "excluded_from_base_bulks")
    private boolean excludedFromBaseBulks;
    @Column(name = "manually_blacklisted")
    private boolean manuallyBlacklisted;
    @Column(name = "last_updated")
    private Timestamp lastUpdated;
    @Column(name = "is_loaded_in_cache")
    private boolean loadedInCache;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public boolean isExcludedFromDialogue() {
        return excludedFromDialogue;
    }

    public void setExcludedFromDialogue(boolean excludedFromDialogue) {
        this.excludedFromDialogue = excludedFromDialogue;
    }

    public boolean isExcludedFromBaseBulks() {
        return excludedFromBaseBulks;
    }

    public void setExcludedFromBaseBulks(boolean excludedFromBaseBulks) {
        this.excludedFromBaseBulks = excludedFromBaseBulks;
    }

    public boolean isManuallyBlacklisted() {
        return manuallyBlacklisted;
    }

    public void setManuallyBlacklisted(boolean manuallyBlacklisted) {
        this.manuallyBlacklisted = manuallyBlacklisted;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean isLoadedInCache() {
        return loadedInCache;
    }

    public void setLoadedInCache(boolean loadedInCache) {
        this.loadedInCache = loadedInCache;
    }
}
