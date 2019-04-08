package com.ice.automation.commons.exceptions;

public class ContactLockedException extends RuntimeException {

    public ContactLockedException() {
        super();
    }

    public ContactLockedException(String message) {
        super(message);
    }

    public ContactLockedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactLockedException(Throwable cause) {
        super(cause);
    }
}
