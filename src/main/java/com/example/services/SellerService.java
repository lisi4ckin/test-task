package com.example.services;
import com.example.dto.MapperDto;
import com.example.dto.SellersDto;
import com.example.entities.Sellers;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class SellerService {

    @Inject
    MapperDto mapperDto;

    public void getAllSellers(){
        mapperDto.SellersListToSellersDtoList(Sellers.getAllSellers());
    }

    public void addSeller(SellersDto seller){
        Sellers.addSeller(mapperDto.SellersDtoToSellers(seller));
    }

    public void deleteSeller(Long id){
        Sellers.deleteSeller(id);
    }

    public void updateSellers(SellersDto sellersDto){
        Sellers.updateSeller(mapperDto.SellersDtoToSellers(sellersDto));
    }

}
