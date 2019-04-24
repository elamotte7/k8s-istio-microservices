package com.sedona.test.microservicespring.a.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServiceBClientImpl implements ServiceBClient {

    @Value("${serviceB_host:localhost}")
    private String serviceB_host;

    @Value("${serviceB_http_port:9090}")
    private String serviceB_http_port;

    @Value("${serviceB_context_root:/service-b}")
    private String serviceB_context_root;

    private RestTemplate restTemplate;

    @Autowired
    public ServiceBClientImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public String hello() {
        return this.restTemplate.getForObject("http://" + serviceB_host
                + ":" + serviceB_http_port + "/" + serviceB_context_root + "/hello", String.class);
    }


}
