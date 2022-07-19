package com.example.dto;

import com.example.entities.Buyers;
import com.example.entities.Districts;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class BuyersDistrictsDto {
    @NotNull(groups = ValidationGroups.Put.class)
    @Null(groups = ValidationGroups.Post.class)
    public Long id;

    @NotNull
    public Long buyerId;

    @NotNull
    public Long districtId;
}
