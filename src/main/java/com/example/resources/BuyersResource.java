package com.example.resources;

import com.example.dto.BuyersDto;
import com.example.services.BuyerService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/buyer")
public class BuyersResource {
    @Inject
    BuyerService buyerService;

    @POST
    public Response addBuyer(@Valid BuyersDto buyersDto){
        buyerService.addBuyer(buyersDto);
        return Response.ok().build();
    }

    @GET
    public Response getBuyers(){
        return Response.ok(buyerService.getBuyersList()).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBuyer(@PathParam("id") Long id){
        buyerService.deleteBuyer(id);
        return Response.ok().build();
    }

    @PUT
    public Response updateBuyer(@Valid BuyersDto buyersDto){
        buyerService.updateBuyer(buyersDto);
        return Response.ok().build();
    }
}
