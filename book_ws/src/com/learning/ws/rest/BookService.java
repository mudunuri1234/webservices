package com.learning.ws.rest;

import javax.ws.rs.*;

@Path("/bookservice/")
@Produces("text/plain")
public interface BookService {

    @GET
    @Path("/book/{year}")
    String getBooks(@PathParam("year")String year,
                    @MatrixParam("author")String author,
                    @MatrixParam("country")String country);

//    @GET
//    @Path("/books")
//    String getBooks(@MatrixParam("")Book bookBean);
}
