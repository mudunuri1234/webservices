package com.learning.ws.rest;

import javax.ws.rs.*;

@Path("/document/")
@Produces("text/plain")
public interface DocumentManager {

    @GET
    @Path("/read/{id}")
    public String getDocument(@PathParam("id")String id);

    @POST
    @Path("/add/{id}")
    @Consumes("application/x-www-form-urlencoded")
    public void addDocument(@PathParam("id")String id);

    @POST
    @Path("/deleteReplace/{id}")
    @Consumes("application/x-www-form-urlencoded")
    public void deleteOrReplaceDocument(@PathParam("id")String id);

    @DELETE
    public void deleteDocument(String id);

    @PUT
    public void replaceDocument(String id);

}
