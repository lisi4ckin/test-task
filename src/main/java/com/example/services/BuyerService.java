package com.example.services;

import com.example.dto.BuyersDistrictsDto;
import com.example.dto.BuyersRequestDto;
import com.example.dto.BuyersResponseDto;
import com.example.dto.MapperDto;
import com.example.entities.Buyers;
import com.example.entities.BuyersDistricts;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BuyerService {
    @Inject
    MapperDto mapperDto;

    @Inject
    BuyersDistrictsService buyersDistrictsService;

    public void addBuyer(BuyersRequestDto buyerDto){
        Long buyerId = Buyers.addBuyer(mapperDto.BuyersRequestDtoToBuyers(buyerDto));
        if(buyerDto.buyerDistrictsId == null)
            return;
        for(Long id : buyerDto.buyerDistrictsId){
            BuyersDistrictsDto buyersDistrictsDto = new BuyersDistrictsDto();
            buyersDistrictsDto.buyerId = buyerId;
            buyersDistrictsDto.districtId = id;
            buyersDistrictsService.addBuyersDistricts(buyersDistrictsDto);
        }
    }

    public void deleteBuyer(Long id){
        Buyers.deleteBuyer(id);
    }

    public List<BuyersResponseDto> getBuyersList(){
        return mapperDto.BuyersListToBuyersDtoList(Buyers.listAll());
    }

    public void updateBuyer(BuyersRequestDto buyerDto){
        Buyers.updateBuyer(mapperDto.BuyersRequestDtoToBuyers(buyerDto));
    }

    public BuyersResponseDto getOne(Long id){
        return mapperDto.BuyersToBuyersResponseDto(Buyers.findById(id));
    }
}
