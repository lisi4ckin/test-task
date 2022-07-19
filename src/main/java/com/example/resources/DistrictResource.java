package com.example.resources;

import com.example.dto.DistrictsDto;
import com.example.entities.Districts;
import com.example.services.DistrictService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/district")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DistrictResource {

    @Inject
    DistrictService districtService;

    @GET
    public Response getDistricts(){
        districtService.getDistricts();
        return Response.ok().build();
    }

    @POST
    @Path("/AddDistrict")
    public Response add(@Valid DistrictsDto districts){
        districtService.addDistrict(districts);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDistrict(@PathParam("id") Long districtId){
        districtService.deleteDistrict(districtId);
        return Response.ok().build();
    }

    @PUT
    public Response updateDistrict(@Valid DistrictsDto districtsDto){
        districtService.updateDistrict(districtsDto);
        return Response.ok().build();
    }
}
