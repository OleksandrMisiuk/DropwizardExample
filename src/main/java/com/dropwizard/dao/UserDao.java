package com.dropwizard.dao;

import com.dropwizard.domain.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(long id);
}
