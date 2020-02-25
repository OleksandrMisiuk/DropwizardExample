package com.dropwizard.dao;

import com.dropwizard.domain.User;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import javax.inject.Inject;
import java.util.List;

public class UserDaoImpl implements UserDao {

    MongoClient mongoClient;
    Morphia morphia;
    Datastore datastore;

    @Inject
    public UserDaoImpl(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
        morphia = new Morphia();
        datastore = morphia.createDatastore(mongoClient, "dropwizardEx");
    }

    public List<User> getAllUsers() {
        return datastore.createQuery(User.class).asList();
    }

    public User getUserById(long id) {
        return null;
    }
}
