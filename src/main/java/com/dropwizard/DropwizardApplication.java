package com.dropwizard;

import com.dropwizard.service.UserService;
import com.dropwizard.service.UserServiceImpl;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class DropwizardApplication extends Application<DropwizardConfiguration> {
    public static void main(String ... args) throws Exception {
        new DropwizardApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<DropwizardConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(DropwizardConfiguration dropwizardConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new AbstractBinder() {
            @Override
            protected void configure() {
              bind(UserServiceImpl.class).to(UserService.class);
            }
        });
        environment.jersey().register(DropwizardResource.class);
    }
}
