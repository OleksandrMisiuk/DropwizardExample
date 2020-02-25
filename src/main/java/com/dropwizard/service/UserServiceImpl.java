package com.dropwizard.service;

public class UserServiceImpl implements UserService {
    public String getGreeting(String name) {
        return "Hello " + name;
    }
}
