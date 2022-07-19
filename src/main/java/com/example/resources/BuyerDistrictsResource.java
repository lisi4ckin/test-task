package com.example.resources;

import com.example.dto.BuyersDistrictsDto;
import com.example.dto.ValidationGroups;
import com.example.services.BuyersDistrictsService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.groups.ConvertGroup;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/buyerdistricts")
public class BuyerDistrictsResource {
    @Inject
    BuyersDistrictsService buyersDistrictsService;

    @POST
    public Response addBuyerDistrict(@Valid @ConvertGroup(to = ValidationGroups.Post.class) BuyersDistrictsDto buyersDistricts){
        buyersDistrictsService.addBuyersDistricts(buyersDistricts);
        return Response.ok().build();
    }

    @PUT
    public Response updateBuyersDistricts(@Valid @ConvertGroup(to=ValidationGroups.Put.class) BuyersDistrictsDto buyersDistrictsDto){
        buyersDistrictsService.updateBuyersDistricts(buyersDistrictsDto);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBuyersDistricts(@PathParam("id") Long id){
        buyersDistrictsService.deleteBuyersDistricts(id);
        return Response.ok().build();
    }

    @GET
    public Response getBuyersDistricts(){
        return Response.ok(buyersDistrictsService.getBuyersDistricts()).build();
    }

}
