package com.dropwizard.service;

import com.dropwizard.dao.UserDao;
import com.dropwizard.domain.User;

import javax.inject.Inject;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao;

    @Inject
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getGreeting(String name) {
        return "Hello " + name;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
