package org.praveen.resolver;


import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;

public class ExceptionResolver extends
        SimpleMappingExceptionResolver {

    @Override
    public String buildLogMessage(Exception ex, HttpServletRequest request) {
        return "Spring MVC exception Occurred: " + ex.getLocalizedMessage();
    }
}
