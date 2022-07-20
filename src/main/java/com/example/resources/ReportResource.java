package com.example.resources;

import com.example.services.ReportService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
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

    @POST
    @Path("/download")
    public Response getDownloadFile() throws IOException {
        reportService.getXlsFile(reportService.getReport());
        File xls = new File("temp.xlsx");
        return Response.ok(xls, MediaType.APPLICATION_OCTET_STREAM).header("Content-Disposition", "attachment; filename=\"" + xls.getName() + "\"" )
                .build();
    }
}
