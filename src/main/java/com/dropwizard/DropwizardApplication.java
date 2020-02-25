package com.dropwizard;

import com.dropwizard.dao.UserDao;
import com.dropwizard.dao.UserDaoImpl;
import com.dropwizard.service.UserService;
import com.dropwizard.service.UserServiceImpl;
import com.mongodb.MongoClient;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

//import io.federecio.dropwizard.swagger.SwaggerBundle;
//import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class DropwizardApplication extends Application<DropwizardConfiguration> {
    public static void main(String ... args) throws Exception {
        new DropwizardApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<DropwizardConfiguration> bootstrap) {
        super.initialize(bootstrap);
//        bootstrap.addBundle(new SwaggerBundle<DropwizardConfiguration>() {
//            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(DropwizardConfiguration dropwizardConfiguration) {
//                return dropwizardConfiguration.getSwaggerBundleConfiguration();
//            }
//        });
    }

    @Override
    public void run(DropwizardConfiguration dropwizardConfiguration, Environment environment) throws Exception {
        final MongoClient mongoClient = new MongoClient("localhost",27017);
        environment.jersey().register(new AbstractBinder() {
            @Override
            protected void configure() {
              bind(UserServiceImpl.class).to(UserService.class);
              bind(mongoClient).to(MongoClient.class);
              bind(UserDaoImpl.class).to(UserDao.class);
            }
        });
        environment.jersey().register(DropwizardResource.class);
    }
}
