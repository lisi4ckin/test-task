package com.example.services;


import com.example.dto.DistrictsDto;
import com.example.dto.MapperDto;
import com.example.entities.Districts;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class DistrictService {

    @Inject
    MapperDto mapperDto;

    public List<DistrictsDto> getDistricts(){
        return mapperDto.DistrictListToDistrictDtoList(Districts.getAllDistricts());
    }

    public void addDistrict(DistrictsDto districtsDto){
        Districts.addDistrict(mapperDto.DistrictsDtoToDistricts(districtsDto));
    }

    public void deleteDistrict(Long distictId){
        Districts.deleteDistrict(distictId);
    }

    public void updateDistrict(DistrictsDto districtsDto){
        Districts.updateDistrict(mapperDto.DistrictsDtoToDistricts(districtsDto));
    }

    public DistrictsDto getOne(Long id){
        return mapperDto.DistrictsToDistrictsDto(Districts.findById(id));
    }
}
