package com.ice.automation.commons.bulk;


public enum BulkStatus {
    SCHEDULED,               // If the bulk is scheduled to run
    RUNNING,                 // If the bulk is running
    ENDED,                   // If the bulk is finished
    PAUSED,                  // If the bulk is paused
    CANCELED_BY_USER,        // If the bulk is cancelled manually
    CANCELED_AUTOMATICALLY,  // If the bulk is cancelled automatically
    FAILED,                  // If the bulk has failed to complete
    EXPIRED                  // If the bulk is Expired
}
