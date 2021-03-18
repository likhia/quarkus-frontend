package org.acme.getting.started;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/greeting")
@RegisterRestClient
public interface HelloService {

    @GET
    @Path("/message/{name}")
    String getMessage(@PathParam String name);
}