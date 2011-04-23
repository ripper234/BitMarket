package com.mashlife;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mashlife.di.StandardModule;
import com.mashlife.model.Location;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.unitils.UnitilsTestNG;

public class MlTestBase extends UnitilsTestNG {
    private Injector injector;

    @BeforeSuite
    public void beforeMlTestBase() {
        StandardModule module = new StandardModule();
        injector = Guice.createInjector(module);
    }

    protected Injector getInjector() {
        return injector;
    }
}
