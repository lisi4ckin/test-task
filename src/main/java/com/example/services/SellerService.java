package com.example.services;
import com.example.dto.MapperDto;
import com.example.dto.SellersRequestDto;
import com.example.dto.SellersResponseDto;
import com.example.entities.Sellers;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class SellerService {

    @Inject
    MapperDto mapperDto;

    public List<SellersResponseDto> getAllSellers(){
        return mapperDto.SellersListToSellersDtoList(Sellers.getAllSellers());
    }

    public void addSeller(SellersRequestDto seller){
        Sellers.addSeller(mapperDto.SellersDtoToSellers(seller));
    }

    public void deleteSeller(Long id){
        Sellers.deleteSeller(id);
    }

    public void updateSellers(SellersRequestDto sellersDto){
        Sellers.updateSeller(mapperDto.SellersDtoToSellers(sellersDto));
    }

    public SellersResponseDto getOne(Long id){
        return mapperDto.SellersToSellersDto(Sellers.findById(id));
    }
}
