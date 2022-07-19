package com.example.resources;

import com.example.services.ReportService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/report")
public class ReportResource {
    @Inject
    ReportService reportService;

    @GET
    public Response getReport(){
        return Response.ok(reportService.getReport()).build();
    }

}
