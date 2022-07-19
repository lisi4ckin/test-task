package com.example.dto;

import com.example.entities.Buyers;
import com.example.entities.BuyersDistricts;
import com.example.entities.Districts;
import com.example.entities.Sellers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "cdi")
public interface MapperDto {
    Sellers SellersDtoToSellers(SellersDto sellersDto);
    List<SellersDto> SellersListToSellersDtoList(List<Sellers> sellersList);
    SellersDto SellersToSellersDto(Sellers sellers);

    Buyers BuyersDtoToBuyers(BuyersDto buyersDto);
    List<BuyersDto> BuyersListToBuyersDtoList(List<Buyers> buyersList);
    BuyersDto BuyersToBuyersDto(Buyers buyers);

    Districts DistrictsDtoToDistricts(DistrictsDto districtsDto);
    List<DistrictsDto> DistrictListToDistrictDtoList(List<Districts> districtsLists);
    DistrictsDto DistrictsToDistrictsDto(Districts districts);


    BuyersDistricts BuyersDistrictsDtoToBuyersDistricts(BuyersDistrictsDto buyersDistrictsDto);


    List<BuyersDistrictsDto> BuyersDistrictsListToBuyersDistrictsDtoList(List<BuyersDistricts> buyersDistrictsList);

    @Mappings({
            @Mapping(source = "buyer.id", target = "buyerId"),
            @Mapping(source = "district.id", target = "districtId"),
    })
    BuyersDistrictsDto BuyersDistrictsToBuyersDistrictsDto(BuyersDistricts buyersDistricts);
}
