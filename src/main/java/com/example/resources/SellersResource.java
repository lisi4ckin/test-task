package com.example.resources;

import com.example.dto.SellersDto;
import com.example.services.SellerService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/seller")
public class SellersResource {

    @Inject
    SellerService sellerService;

    @GET
    public Response getSellers(){
        sellerService.getAllSellers();
        return Response.ok().build();
    }

    @POST
    @Path("/AddSeller")
    public Response addSeller(@Valid SellersDto seller){
        sellerService.addSeller(seller);
        return Response.ok().build();
    }

    @PUT
    public Response updateSeller(@Valid SellersDto sellersDto){
        sellerService.updateSellers(sellersDto);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteSeller(@PathParam("id")Long id){
        sellerService.deleteSeller(id);
        return Response.ok().build();
    }
}
