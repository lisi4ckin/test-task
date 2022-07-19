package com.example.resources;

import com.example.dto.DistrictsDto;
import com.example.entities.Districts;
import com.example.services.DistrictService;

import javax.inject.Inject;
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
        return districtService.getDistricts();
    }

    @POST
    @Path("/AddDistrict")
    public void add(DistrictsDto districts){
        districtService.addDistrict(districts);
    }

    @DELETE
    @Path("/{id}")
    public void deleteDistrict(@PathParam("id") Long districtId){
        districtService.deleteDistrict(districtId);
    }

    @PUT
    @Path("/{id}")
    public void updateDistrict(@PathParam("id") Long districtId){
        districtService.updateDistrict(districtId);
    }
}
