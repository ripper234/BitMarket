package com.bitmarket.services.dal;

import com.bitmarket.model.User;

/**
 * Created by IntelliJ IDEA.
 * User: rgross
 * Date: 4/30/11
 * Time: 2:34 PM
 */
public interface UserRepository {
    User read(long id);
}

