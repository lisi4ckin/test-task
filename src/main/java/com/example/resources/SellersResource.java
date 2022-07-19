package com.example.resources;

import com.example.dto.SellersDto;
import com.example.services.SellerService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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
        return sellerService.getAllSellers();
    }

    @POST
    @Path("/AddSeller")
    public Response addSeller(SellersDto seller){
        return sellerService.addSeller(seller);
    }

}
