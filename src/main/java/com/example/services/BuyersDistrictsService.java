package com.example.services;

import com.example.dto.BuyersDistrictsDto;
import com.example.dto.MapperDto;
import com.example.entities.BuyersDistricts;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BuyersDistrictsService {
    @Inject
    MapperDto mapperDto;

    public void addBuyersDistricts(BuyersDistrictsDto buyersDistrictsDto){
        BuyersDistricts.addBuyersDistrict(mapperDto.BuyersDistrictsDtoToBuyersDistricts(buyersDistrictsDto));
    }

    public void deleteBuyersDistricts(Long id){
        BuyersDistricts.deleteBuyersDistrict(id);
    }

    public void updateBuyersDistricts(BuyersDistrictsDto buyersDistrictsDto){
        BuyersDistricts.updateBuyersDistrict(mapperDto.BuyersDistrictsDtoToBuyersDistricts(buyersDistrictsDto));
    }

    public List<BuyersDistrictsDto> getBuyersDistricts(){
        return mapperDto.BuyersDistrictsListToBuyersDistrictsDtoList(BuyersDistricts.getBuyersDistricts());
    }

    public BuyersDistrictsDto getOne(Long id){
        return mapperDto.BuyersDistrictsToBuyersDistrictsDto(BuyersDistricts.findById(id));
    }
}
