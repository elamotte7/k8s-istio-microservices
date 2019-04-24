package com.sedona.test.microprofile.a.rest;

import com.sedona.test.microprofile.a.rest.client.ServiceBClientImpl;
import com.sedona.test.microprofile.a.rest.model.ServiceData;
import com.sedona.test.microprofile.a.rest.model.TracerHeaders;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metric;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RequestScoped
public class ServiceA {

    @Inject
    ServiceBClientImpl serviceBClient;

    @Inject
    @Metric(name="callCounter")
    Counter callCounter;

    @Counted(name="callCounter", monotonic=true)
    public ServiceData call(TracerHeaders ts) throws Exception {

        long callCount = callCounter.getCount();

        Future<ServiceData> serviceBFuture = serviceBClient.call(ts);
        ServiceData serviceBData = serviceBFuture.get(60, TimeUnit.SECONDS);

        ServiceData data = new ServiceData();
        data.setSource(this.toString());
        data.setMessage("Hello from serviceA @ "+data.getTime());
        data.setData(serviceBData);
        data.setCallCount(callCount);
        data.setTries(1);

        return data;
    }

}
