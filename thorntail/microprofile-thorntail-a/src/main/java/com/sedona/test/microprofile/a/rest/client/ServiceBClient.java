package com.sedona.test.microprofile.a.rest.client;

import com.sedona.test.microprofile.a.rest.model.ServiceData;
import com.sedona.test.microprofile.a.rest.model.Todo;
import com.sedona.test.microprofile.a.rest.provider.JsonProvider;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.Dependent;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@RegisterRestClient
//@Dependent
@RegisterProvider(JsonProvider.class)
public interface ServiceBClient {
    //Currently produces plain text but will soon be converted to json
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String callPlainText() throws Exception;

    @GET
    @Path("/call")
    @Produces(MediaType.APPLICATION_JSON)
    ServiceData call(@HeaderParam("end-user") String user,
                     @HeaderParam("x-request-id") String xreq,
                     @HeaderParam("x-b3-traceid") String xtraceid,
                     @HeaderParam("x-b3-spanid") String xspanid,
                     @HeaderParam("x-b3-parentspanid") String xparentspanid,
                     @HeaderParam("x-b3-sampled") String xsampled,
                     @HeaderParam("x-b3-flags") String xflags,
                     @HeaderParam("x-ot-span-context") String xotspan) throws Exception;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    String hello() throws Exception;

    @GET
    @Path("/hello/propertyString")
    @Produces(MediaType.TEXT_PLAIN)
    String propertyString() throws Exception;

    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
    List<Todo> todos() throws Exception;


}
