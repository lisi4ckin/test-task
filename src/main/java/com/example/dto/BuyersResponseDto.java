package com.example.dto;

import com.example.entities.BuyersDistricts;

import java.util.List;

public class BuyersResponseDto {
    public Long id;

    public String buyerName;

    public String buyerPhone;

    public List<BuyersDistricts> buyerDistricts;

    public Float houseAreaGTE;

    public Float houseAreaLTE;

    public Float maxPrice;

    public Integer buyerFilters;
}

