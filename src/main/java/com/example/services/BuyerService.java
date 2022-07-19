package com.example.services;

import com.example.dto.BuyersDto;
import com.example.dto.MapperDto;
import com.example.entities.Buyers;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BuyerService {
    @Inject
    MapperDto mapperDto;

    public void addBuyer(BuyersDto buyerDto){
        Buyers.addBuyer(mapperDto.BuyersDtoToBuyers(buyerDto));
    }

    public void deleteBuyer(Long id){
        Buyers.deleteBuyer(id);
    }

    public List<BuyersDto> getBuyersList(){
        return mapperDto.BuyersListToBuyersDtoList(Buyers.listAll());
    }

    public void updateBuyer(BuyersDto buyerDto){
        Buyers.updateBuyer(mapperDto.BuyersDtoToBuyers(buyerDto));
    }
}
