package com.sedona.test.microprofile.b.rest;


import com.sedona.test.microprofile.b.model.Todo;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.logging.Logger;

@ApplicationScoped
@Path("/hello")
public class HelloWorldEndpoint {

    @Inject
    private Logger log;

    @Inject
    @ConfigurationValue("some.string.property")
    private String stringProperty;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response doGet() {
        System.out.println("test");
        System.out.println(this.stringProperty);
        log.info(this.stringProperty);
        return Response.ok("Hello World welcome to Thorntail Microservice B v2!!!!!").build();
    }

    @GET
    @Path("/propertyString")
    @Produces(MediaType.TEXT_PLAIN)
    public String getStringProperty() {
        if (null == stringProperty) throw new RuntimeException("config property not initialised");
        return stringProperty;
    }
}
