package com.bitmarket.services.dal;

import com.bitmarket.model.User;

public class HibernateUserRepository extends HibernateRepositoryBase<User> implements UserRepository{
    protected HibernateUserRepository(Class<User> clazz) {
        super(clazz);
    }
}

