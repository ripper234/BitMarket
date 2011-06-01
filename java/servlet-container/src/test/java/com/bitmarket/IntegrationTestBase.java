package com.bitmarket;

import com.bitmarket.services.dal.DbUtil;
import org.hibernate.SessionFactory;
import org.testng.annotations.BeforeMethod;

public class IntegrationTestBase extends BmTestBase {
    @BeforeMethod
    public final void beforeIntegrationTestBase() {
        SessionFactory foo = getInstance(SessionFactory.class);
        getInstance(DbUtil.class).cleanDatabase();
    }
}
