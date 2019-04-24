package com.sedona.test.microprofile.b.rest;

import com.sedona.test.microprofile.b.model.ServiceData;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/call")
public class ServiceBEndpoint {

    @Inject
    ServiceB serviceB;

    @GET
    @Path("/text")
    @Produces(MediaType.TEXT_PLAIN)
    public Response callPlainText() throws Exception {
        ServiceData data = (ServiceData) call().getEntity();
        return Response.ok(data.getMessage() + " " + data.getSource()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response call() throws Exception {
        ServiceData data = serviceB.call();
        return Response.ok(data).build();
    }
}
