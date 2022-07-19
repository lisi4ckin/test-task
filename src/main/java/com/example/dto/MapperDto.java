package com.example.dto;

import com.example.entities.Buyers;
import com.example.entities.Districts;
import com.example.entities.Sellers;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface MapperDto {
    Sellers SellersDtoToSellers(SellersDto sellersDto);
    List<SellersDto> SellersListToSellersDtoList(List<Sellers> sellersList);

    Buyers BuyersDtoToBuyers(BuyersDto buyersDto);
    List<BuyersDto> BuyersListToBuyersDtoList(List<Buyers> buyersList);

    Districts DistrictsDtoToDistricts(DistrictsDto districtsDto);
    List<DistrictsDto> DistrictListToDistrictDtoList(List<Districts> districtsLists);
}
