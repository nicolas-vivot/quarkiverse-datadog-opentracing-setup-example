package org.kij.example.quarkus.opentracing.datadog;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/test")
public class SomeResource
{

    private static final Logger LOGGER = LoggerFactory.getLogger(SomeResource.class.getName());

    @Inject
    SomeService someService;

    @GET
    @Path("/traced")
    public void withTracedSubProcess() {

        LOGGER.info("Before traced operation");
        someService.tracedOperation();
        LOGGER.info("After traced operation");
    }

    @GET
    @Path("/nontraced")
    public void withNonTracedSubProcess() {

        LOGGER.info("Before non traced operation");
        someService.nonTracedOperation();
        LOGGER.info("After non traced operation");
    }

}
