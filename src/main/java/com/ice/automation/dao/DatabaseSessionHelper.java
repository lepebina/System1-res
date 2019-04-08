package com.ice.automation.dao;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("databaseSessionHelper")
public final class DatabaseSessionHelper {

    @Autowired
    private SessionFactory sessionFactory;

    public void setFlushMode(FlushMode flushMode) {
        sessionFactory.getCurrentSession().setFlushMode(flushMode);
    }

    public void clearSession() {
        sessionFactory.getCurrentSession().clear();
    }

    public void flushSession() {
        sessionFactory.getCurrentSession().flush();
    }

    public void flushAndClearSession() {
        flushSession();
        clearSession();
    }
}
