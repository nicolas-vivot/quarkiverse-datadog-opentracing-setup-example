package org.kij.example.quarkus.opentracing.datadog;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.opentracing.Traced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class SomeService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SomeService.class.getName());

    @Traced(operationName = "dummy-operation")
    public void tracedOperation() {

        LOGGER.info("Inside child span");
    }

    public void nonTracedOperation() {

        LOGGER.info("Inside parent span");
    }
}
