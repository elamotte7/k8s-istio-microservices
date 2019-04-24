package com.sedona.test.microprofile.a.rest;


import com.sedona.test.microprofile.a.rest.client.ServiceBClientImpl;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@ApplicationScoped
@Path("/hello")
public class HelloWorldEndpoint {

    @Inject
    private Logger log;

    @Inject
    @ConfigurationValue("some.string.property")
    private String stringProperty;

    @Inject
    private ServiceBClientImpl serviceBClient;

    @GET
    @Path("/service-b")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() throws Exception {
        System.out.println("test");
        System.out.println(this.stringProperty);
        log.info(this.stringProperty);
        return Response.ok("The microservice B respond : [" + serviceBClient.hello() + "]").build();
    }

    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response todos() throws Exception {
        System.out.println("todos");

        return Response.ok(serviceBClient.todos()).build();
    }

    @GET
    @Produces("text/plain")
    public Response doGet() {
        System.out.println("test");
        System.out.println(this.stringProperty);
        log.info(this.stringProperty);
        return Response.ok("Hello, welcome to Thorntail Microservice A V2!").build();
    }

    @GET
    @Path("/propertyString")
    @Produces(MediaType.TEXT_PLAIN)
    public String getStringProperty() {
        if (null == stringProperty) throw new RuntimeException("config property not initialised");
        return stringProperty;
    }
}
