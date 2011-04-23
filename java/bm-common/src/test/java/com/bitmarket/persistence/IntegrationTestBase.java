package com.mashlife.persistence;

import com.google.inject.Injector;
import com.mashlife.MlTestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class IntegrationTestBase extends MlTestBase {
    @BeforeMethod
    public final void beforeIntegrationTestBase()
    {
        final DbUtil dbUtil = getInjector().getInstance(DbUtil.class);
        dbUtil.cleanDatabase();
    }
}
