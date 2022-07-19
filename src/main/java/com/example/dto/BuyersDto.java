package com.example.dto;

import com.example.entities.Districts;
import com.example.entities.Filters;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

public class BuyersDto {
    @Null(groups = ValidationGroups.Post.class)
    @NotNull(groups = ValidationGroups.Put.class)
    public Long id;

    @NotBlank
    public String buyerName;
    @NotBlank
    public String buyerPhone;

    public List<Districts> buyerDistricts;

    @NotNull
    @Min(1)
    public Float houseAreaGTE;

    @NotNull
    @Min(1)
    public Float houseAreaLTE;

    @NotNull
    @Min(0)
    public Float maxPrice;

    public Filters buyerFilters;
}

