package com.sedona.test.microprofile.b.rest;

import com.sedona.test.microprofile.b.model.ServiceData;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metric;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.net.InetAddress;
import java.util.Random;

@ApplicationScoped
public class ServiceB {

    @Inject
    @ConfigProperty(name = "minWorkTime", defaultValue = "100") //how long should the minimum simulated work be in ms
    private long minWorkTime;

    @Inject
    @ConfigProperty(name = "maxWorkTime", defaultValue = "5000") //how long should the maximum simulated work be in ms
    private long maxWorkTime;

    private Random random = new Random();

    @Inject
    @Metric(name = "callCounter")
    Counter callCounter;

    @Counted(name = "callCounter", monotonic = true)
    public ServiceData call() throws Exception {
        long callCount = callCounter.getCount();

        simulateWork();

        String hostname;
        try {
            hostname = InetAddress.getLocalHost()
                    .getHostName();
        } catch (java.net.UnknownHostException e) {
            hostname = e.getMessage();
        }

        ServiceData data = new ServiceData();
        data.setSource(this.toString() + " on " + hostname);
        data.setMessage("Hello from serviceB @ " + data.getTime());
        data.setCallCount(callCount);
        data.setTries(1);

        return data;
    }

    /**
     * Simulate some work that takes somewhere between minWorkTime and maxWorkTime (in millis)
     */
    private void simulateWork() throws Exception {
        //simulate some work
        double randomDouble = random.nextDouble();
        long delta = (long) ((maxWorkTime - minWorkTime) * randomDouble);
        long workTime = minWorkTime + delta;

        Thread.sleep(workTime);
    }
}