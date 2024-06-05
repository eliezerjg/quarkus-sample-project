package com.app.rest.controllers.infra;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/observability")
public class ObservabilityController {

    @Inject
    PrometheusMeterRegistry prometheusRegistry;

    @GET
    @Path("/metrics/prometheus")
    @Produces(MediaType.TEXT_PLAIN)
    public String prometheusMetrics() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(prometheusRegistry.scrape());
    }
}
