package com.dropwizard.service;

import com.dropwizard.domain.User;

import java.util.List;

public interface UserService {
    String getGreeting(String name);
    List<User> getAllUsers();
}
