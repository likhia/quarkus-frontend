package org.acme.getting.started;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/greeting")
public class GreetingResource {

    @Inject
    GreetingService service;

    @Inject
    @RestClient
    BackendService backendService;

    @Inject
    @RestClient
    HelloService helloService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello/{name}")
    public String hello(@PathParam String name) {
        return service.greeting(backendService.getByName(name));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/message/{name}")
    public String message(@PathParam String name) {
        return service.greeting(helloService.getMessage(name));
    }
    
}