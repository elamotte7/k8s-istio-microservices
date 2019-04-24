package com.sedona.test.microprofile.a.rest.client;

import com.sedona.test.microprofile.a.rest.model.ServiceData;
import com.sedona.test.microprofile.a.rest.model.Todo;
import com.sedona.test.microprofile.a.rest.model.TracerHeaders;
import com.sedona.test.microprofile.a.rest.provider.JsonProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.*;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
@ApplicationScoped
public class ServiceBClientImpl {
    @Inject
    @ConfigProperty(name = "serviceB_host", defaultValue = "localhost")
    String serviceB_host;

    @Inject
    @ConfigProperty(name = "serviceB_http_port", defaultValue = "9090")
    String serviceB_http_port;

    @Inject
    @ConfigProperty(name = "serviceB_context_root", defaultValue = "/service-b")
    String serviceB_context_root;

    private int tries;

    @Retry(maxRetries = 5)
    @Fallback(fallbackMethod = "fallback")
    @CircuitBreaker(failureRatio = 0.5, requestVolumeThreshold = 4, successThreshold = 2, delay = 10000, delayUnit = ChronoUnit.MILLIS)
    @Asynchronous
    @Timeout(value = 2000, unit = ChronoUnit.MILLIS)
    public Future<ServiceData> call(TracerHeaders ts) throws Exception {
        ++tries;

        ServiceBClient serviceBClient = getServiceBClient();


        ServiceData serviceBData = serviceBClient.call(ts.user, ts.xreq, ts.xtraceid, ts.xspanid, ts.xparentspanid,
                ts.xsampled, ts.xflags, ts.xotspan);

        serviceBData.setTries(getTries());

        return CompletableFuture.completedFuture(serviceBData);
    }

    public Future<ServiceData> fallback(TracerHeaders ts) {

        ServiceData data = new ServiceData();
        data.setSource(this.toString());
        data.setCallCount(1);
        data.setMessage("ServiceBClient fallback @ " + data.getTime() + ". ServiceB could not be reached at: " + getURL());
        data.setTries(getTries());
        data.setFallback(true);

        return CompletableFuture.completedFuture(data);
    }

    int getTries() {
        return tries;
    }

    public Object hello() throws Exception {
        ServiceBClient serviceBClient = getServiceBClient();
        return serviceBClient.hello();
    }

    public List<Todo> todos() throws Exception {
        ServiceBClient serviceBClient = getServiceBClient();
        List<Todo> response = serviceBClient.todos();
        //return Response.ok(response).build();
        return response;
    }

    private ServiceBClient getServiceBClient() throws MalformedURLException {
        String urlString = getURL();
        URL url = new URL(urlString);

        return RestClientBuilder.newBuilder()
                .baseUrl(url)
                .register(JsonProvider.class)
                .build(ServiceBClient.class);
    }

    private String getURL() {
        String slash = "/";
        if (serviceB_context_root.startsWith(slash)) {
            slash = "";
        }
        return "http://" + serviceB_host + ":" + serviceB_http_port + slash + serviceB_context_root;
    }

}
