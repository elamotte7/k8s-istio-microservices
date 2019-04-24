package com.sedona.test.microprofile.a.rest;

import com.sedona.test.microprofile.a.rest.model.ServiceData;
import com.sedona.test.microprofile.a.rest.model.TracerHeaders;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/call")
public class ServiceAEndpoint {

    @Inject
    private ServiceA serviceA;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ServiceData callServiceA(@HeaderParam("end-user") String user,
                                    @HeaderParam("x-request-id") String xreq,
                                    @HeaderParam("x-b3-traceid") String xtraceid,
                                    @HeaderParam("x-b3-spanid") String xspanid,
                                    @HeaderParam("x-b3-parentspanid") String xparentspanid,
                                    @HeaderParam("x-b3-sampled") String xsampled,
                                    @HeaderParam("x-b3-flags") String xflags,
                                    @HeaderParam("x-ot-span-context") String xotspan) throws Exception {

        TracerHeaders ts = new TracerHeaders();
        ts.user = user;
        ts.xreq = xreq;
        ts.xtraceid = xtraceid;
        ts.xspanid = xspanid;
        ts.xparentspanid = xparentspanid;
        ts.xsampled = xsampled;
        ts.xflags = xflags;
        ts.xotspan = xotspan;


        ServiceData data = serviceA.call(ts);

        return data;
    }
}