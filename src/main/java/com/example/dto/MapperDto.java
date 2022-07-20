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
    @Mapping(source = "districtId", target = "sellerDistrict.id")
    Sellers SellersDtoToSellers(SellersRequestDto sellersDto);
    List<SellersResponseDto> SellersListToSellersDtoList(List<Sellers> sellersList);
    SellersResponseDto SellersToSellersDto(Sellers sellers);

//    @Mapping(source = "buyerDistrictsId", target = "buyerDistricts")
    Buyers BuyersRequestDtoToBuyers(BuyersRequestDto buyersDto);

//    default List<BuyersDistricts> BuyersDistrictsIdToBuyersDistricts(List<Long> idsList){
//        if(idsList == null)
//            return null;
//        List<BuyersDistricts> buyersDistrictsList = new ArrayList<>();
//        for(Long id : idsList){
//            BuyersDistricts buyersDistricts = new BuyersDistricts();
//            buyersDistricts.id = id;
//            buyersDistrictsList.add(buyersDistricts);
//        }
//        return buyersDistrictsList;
//
//    }
    List<BuyersResponseDto> BuyersListToBuyersDtoList(List<Buyers> buyersList);
    BuyersResponseDto BuyersToBuyersResponseDto(Buyers buyers);

    Districts DistrictsDtoToDistricts(DistrictsDto districtsDto);
    List<DistrictsDto> DistrictListToDistrictDtoList(List<Districts> districtsLists);
    DistrictsDto DistrictsToDistrictsDto(Districts districts);


    @Mappings({
            @Mapping(source = "buyerId", target = "buyer.id"),
            @Mapping(source = "districtId", target = "district.id"),
    })
    BuyersDistricts BuyersDistrictsDtoToBuyersDistricts(BuyersDistrictsDto buyersDistrictsDto);


    List<BuyersDistrictsDto> BuyersDistrictsListToBuyersDistrictsDtoList(List<BuyersDistricts> buyersDistrictsList);

    @Mappings({
            @Mapping(source = "buyer.id", target = "buyerId"),
            @Mapping(source = "district.id", target = "districtId"),
    })
    BuyersDistrictsDto BuyersDistrictsToBuyersDistrictsDto(BuyersDistricts buyersDistricts);
}
