package com.learning.ws.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.HttpHeaders;
import javax.servlet.http.HttpServletRequest;

@Path("/dataservice/")
@Produces("text/plain")
public interface RestDataManager {

    @GET
    @Path("/restinfo")
    public String getCommmonInfo(@Context UriInfo uriInfo,
                                 @Context HttpHeaders headers,
                                 @Context HttpServletRequest req);
}
