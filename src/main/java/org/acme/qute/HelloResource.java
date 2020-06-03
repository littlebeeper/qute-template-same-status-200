package org.acme.qute;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

@Path("/hello")
public class HelloResource {

    @Inject
    Template hello;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response get(@QueryParam("name") String name) {
        return Response
                .status(Response.Status.CREATED)
                .type(MediaType.TEXT_HTML)
                .entity(hello.data("name", name))
                .build();
    }

}
