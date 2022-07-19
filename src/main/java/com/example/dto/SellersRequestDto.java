package com.example.dto;

import com.example.entities.Districts;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class SellersRequestDto {
    @Null(groups = ValidationGroups.Post.class)
    @NotNull(groups = ValidationGroups.Put.class)
    public Long id;

    @NotBlank
    public String sellerName;
    @NotBlank
    public String phone;

    @NotNull(groups = ValidationGroups.Post.class)
    public Long districtId;

    @NotNull
    @Min(1)
    public Integer countFloors;

    @NotNull
    @Min(1)
    public Integer floorNumber;

    @NotNull
    @Min(1)
    public Float houseArea;

    @NotNull
    @Min(0)
    public Float housePrice;
}
