package com.ice.automation.commons;


import java.sql.Timestamp;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class InternalClock {
    private final static Logger logger = LoggerFactory.getLogger(InternalClock.class);

    private static long offsetMillies;

    public static Timestamp now() {
        long now = System.currentTimeMillis();
        Timestamp nowOffset = new Timestamp(now + offsetMillies);
        if (logger.isTraceEnabled()) {
            logger.trace(String.format("System time:'%s', application time:'%s'", new Timestamp(now), nowOffset));
        }
        return nowOffset;
    }

    public static Timestamp truncateToDay(Timestamp dateTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);

        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);

        return new Timestamp(calendar.getTimeInMillis());
    }

    public static long getOffsetMillies() {
        return offsetMillies;
    }

    public static void setOffsetMillies(long offsetMillies) {
        InternalClock.offsetMillies = offsetMillies;
    }
}
