package com.bitmarket;

import com.bitmarket.bootstrap.StandardModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class BmTestBase {

    private Injector injector;

    @BeforeSuite
    public void beforeMlTestBase() {
        injector = Guice.createInjector(getModule());
    }

    protected Module getModule() {
        return new StandardModule();
    }

    private Injector getInjector() {
        return injector;
    }

    protected <T> T getInstance(Class<T> clazz) {
        return getInjector().getInstance(clazz);
    }

    protected <T> void assertEquals(T actual, T expected) {
        Assert.assertEquals(actual, expected);
    }
}
