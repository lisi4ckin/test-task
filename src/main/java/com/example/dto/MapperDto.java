package com.example.dto;

import com.example.entities.Sellers;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface MapperDto {
    Sellers SellersDtoToSellers(SellersDto sellersDto);
    List<SellersDto> SellersListToSellersDtoList(List<Sellers> sellers);

}
