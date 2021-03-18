package org.acme.getting.started;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/country")
@RegisterRestClient
public interface BackendService {

    @GET
    @Path("/name/{name}")
    String getByName(@PathParam String name);
}