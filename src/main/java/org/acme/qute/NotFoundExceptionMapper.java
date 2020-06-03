package org.acme.qute;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.ResourcePath;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
    @ResourcePath("not-found.html")
    Template notFoundTemplate;

    @Override
    public Response toResponse(NotFoundException exception) {

        TemplateInstance notFoundPage = notFoundTemplate.data("exception",exception.getMessage());

        return Response
                .status(NOT_FOUND)
                .entity(notFoundPage)
                .type(MediaType.TEXT_HTML_TYPE)
                .build();
    }
}
