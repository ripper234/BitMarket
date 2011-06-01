package com.bitmarket.services.dal;

import com.bitmarket.IntegrationTestBase;
import com.bitmarket.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserRepositoryTests extends IntegrationTestBase {
    private UserRepository repository;

    @BeforeMethod
    public final void setupUserRepositoryTests() {
        repository = getInstance(UserRepository.class);
    }

    @Test
    public void saveAndReadUser() {
        User user = new User();
        user.setName("John doe");

    }
}
