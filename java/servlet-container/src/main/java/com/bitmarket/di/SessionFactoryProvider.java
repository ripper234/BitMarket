package com.bitmarket.di;

import com.bitmarket.model.User;
import com.google.inject.Provider;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionFactoryProvider implements Provider<SessionFactory> {

    @Override
    public SessionFactory get() {
        final AnnotationConfiguration configuration = new AnnotationConfiguration();

        // todo http://stackoverflow.com/questions/4284584/configuring-hibernates-auto-discovery-via-entitymanager-jpa
        configuration.addAnnotatedClass(User.class);

        return configuration
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
}
