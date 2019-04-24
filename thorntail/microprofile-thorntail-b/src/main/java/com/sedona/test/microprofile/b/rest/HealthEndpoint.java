package com.sedona.test.microprofile.b.rest;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Health
@ApplicationScoped
public class HealthEndpoint implements HealthCheck {

    /*
     *  Health is controlled by a config property
     */
    @Inject
    @ConfigProperty(name = "healthy", defaultValue = "true")
    private boolean healthy;

    @Override
    public HealthCheckResponse call() {
        HealthCheckResponse hcr;

        if (healthy) {
            hcr = HealthCheckResponse.named("serviceB")
                    .withData("healthy", healthy)
                    .up().build();
        } else {
            hcr = HealthCheckResponse.named("serviceB")
                    .withData("healthy", healthy)
                    .down().build();
        }

        System.out.println("Health endpoint called: " + hcr);
        return hcr;
    }
}
