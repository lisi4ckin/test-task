package com.example.resources;

import com.example.services.ReportService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

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

    @GET
    @Path("/get_request")
    public Response getDownloadFile() throws IOException {
        return Response.ok(reportService.getXlsFile(reportService.getReport())).build();
    }
}
