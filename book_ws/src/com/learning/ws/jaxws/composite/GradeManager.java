package com.learning.ws.jaxws.composite;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.jws.WebService;

@WebService
@Path("/compositegradeservice/")
@Produces("application/xml")
public interface GradeManager {

    @GET
    @Path("/grade/{grade}")
    public String getGradeSubjects(@PathParam("grade")Integer grade);

}
