package com.bitmarket;

import org.testng.annotations.BeforeMethod;

public class IntegrationTestBase extends BmTestBase{
    @BeforeMethod
    public final void beforeIntegrationTestBase()
    {
        // todo - clear database between tests
    }
}
