package com.example.services;
import com.example.dto.MapperDto;
import com.example.dto.SellersDto;
import com.example.entities.Sellers;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class SellerService {

    @Inject
    MapperDto mapperDto;

    public Response getAllSellers(){
        return Response.ok(mapperDto.SellersListToSellersDtoList(Sellers.getAllSellers())).build();
    }

    public Response addSeller(SellersDto seller){
        Sellers.addSeller(mapperDto.SellersDtoToSellers(seller));
        return Response.ok().build();
    }
}
