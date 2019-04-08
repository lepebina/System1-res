package com.ice.automation.commons.router.request.async;

import com.ice.automation.commons.router.Transaction;


public interface AsyncService {

    /**
     * Decision method to determine whether the specified transaction requires an SDP Call from to the specified
     * service
     *
     * @param transaction the participant's transaction object
     *
     * @return true if should be handles as an SDP request, otherwise false
     */
    boolean asyncRequestConditionsSatisfied(Transaction transaction);

    /**
     * Method to handle (send) the required SDP Call from to the specified
     * service
     *
     * @param transaction the participant's transaction object
     */
    boolean processPreAsyncCall(Transaction transaction);

    /**
     * Actions to be done after the response of the async system
     *
     * @param transaction the participant's transaction object
     *
     * @return true if request will continue to post async request flow, false otherwise
     */
    boolean processPostAsyncCall(Transaction transaction);

    //    void handleSystemEvent(Transaction transaction);

    String getServiceName();
}
