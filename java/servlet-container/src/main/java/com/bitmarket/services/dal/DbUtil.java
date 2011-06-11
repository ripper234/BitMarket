package com.bitmarket.services.dal;

import com.bitmarket.di.slf4j.InjectLogger;
import com.google.inject.Inject;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.totallycommon.util.Action1;
import org.totallycommon.util.Func1;

public class DbUtil {
    private final SessionFactory sessionFactory;

    @InjectLogger
    private Logger logger;

    @Inject
    public DbUtil(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void cleanDatabase() {
        logger.info("Cleaning database");

        doWithSession(new Action1<Session>() {
            @Override
            public void doSomething(Session session) {
                SQLQuery query = session.createSQLQuery("truncate table checkins");
                // todo http://stackoverflow.com/questions/4285636/best-way-to-truncate-all-tables-with-hibernate
                query.executeUpdate();
            }
        });
    }

    public void doWithSession(final Action1<Session> action) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            action.doSomething(session);
            session.getTransaction().commit();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public <T> T doWithSession(final Func1<T, Session> action) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            return action.doSomething(session);
        }
        finally {
            if (session != null) {
                try {
                    session.getTransaction().commit();
                } catch (HibernateException e) {
                    logger.error("Failed to complete transaction", e);
                }
                session.close();
            }
        }
    }
}
