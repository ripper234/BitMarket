package com.bitmarket.di;

import com.bitmarket.di.slf4j.Slf4jTypeListener;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.matcher.Matchers;
import org.hibernate.SessionFactory;

import java.util.TimeZone;

public class StandardModule extends AbstractModule{
    @Override
    protected void configure() {
        // make sure we're UTC
        // http://stackoverflow.com/questions/508019/jpa-hibernate-store-date-in-utc-time-zone
        TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));

        bind(SessionFactory.class).toProvider(SessionFactoryProvider.class).in(Scopes.SINGLETON);
        bindListener(Matchers.any(), new Slf4jTypeListener());

    }
}
