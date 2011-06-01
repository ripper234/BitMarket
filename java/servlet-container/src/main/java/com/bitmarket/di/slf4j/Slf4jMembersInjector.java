package com.bitmarket.di.slf4j;

import com.google.inject.MembersInjector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class Slf4jMembersInjector<T> implements MembersInjector<T> {
    private final Field field;
    private final Logger logger;

    public Slf4jMembersInjector(Field aField) {
        field = aField;
        logger = LoggerFactory.getLogger(field.getDeclaringClass());
        field.setAccessible(true);
    }

    @Override
    public void injectMembers(T anArg0) {
        try {
            field.set(anArg0, logger);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}