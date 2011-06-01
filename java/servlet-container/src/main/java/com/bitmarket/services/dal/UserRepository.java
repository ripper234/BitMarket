package com.bitmarket.services.dal;

import com.bitmarket.model.User;
import com.google.inject.ImplementedBy;

@ImplementedBy(HibernateUserRepository.class)
public interface UserRepository extends Repository<User>{
}

