package com.bitmarket.services.dal;

import com.bitmarket.model.User;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class MockUserRepository implements UserRepository{
    @Override
    public User read(long id) {
        if (id == 1)
            return createUser(1, "Ron", new BigDecimal("5000.123"));

        if (id == 2)
            return createUser(2, "Yair", 12);

        throw new RuntimeException("Only user IDs 1,2 are supported");
    }

    @Override
    public List<User> readAll() {
        throw new UnsupportedOperationException();
    }

    private User createUser(long id, String name , long balance) {
        return createUser(id, name, new BigDecimal(balance));
    }

    private User createUser(long id, String name, BigDecimal balance) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setBalance(balance);
        user.setRegistrationDate(new Date());
        user.setAvatarUrl("about:blank");
        return user;
    }
}

