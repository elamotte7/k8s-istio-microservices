package com.sedona.test.microprofile.b.rest;


import com.sedona.test.microprofile.b.model.Todo;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Path("/todos")
public class TodoEndpoint {

    @Inject
    private Logger log;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response todos() {
        List<Todo> list = Arrays.asList(Todo.create("Buy milk", "Need milk to coffee"),
                Todo.create("Buy Coffee", "Need Coffee"));
        //GenericEntity<List<Todo>> entity = new GenericEntity<List<Todo>>(list) {};
        return Response.ok(list).build();
        //return list;
    }
}
