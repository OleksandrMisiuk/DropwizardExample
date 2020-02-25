package com.dropwizard;

import com.dropwizard.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello/")
@Produces(MediaType.APPLICATION_JSON)
public class DropwizardResource {

    @Inject
    public UserService userService;

    public DropwizardResource() {
    }

    @Path("/{name}")
    @GET
    public String sayHello(@PathParam("name") String name) {
        return userService.getGreeting(name);
    }

    @GET
    public String greeting(@QueryParam("name") String name) {
        return "Hello " + name;
    }
}
