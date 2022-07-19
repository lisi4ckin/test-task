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

    public List<SellersDto> getAllSellers(){
        return mapperDto.SellersListToSellersDtoList(Sellers.getAllSellers());
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

    public SellersDto getOne(Long id){
        return mapperDto.SellersToSellersDto(Sellers.findById(id));
    }
}
