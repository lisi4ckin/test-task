package com.example.services;

import com.example.dto.BuyersDistrictsDto;
import com.example.dto.MapperDto;
import com.example.entities.BuyersDistricts;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class BuyersDistrictsService {
    @Inject
    MapperDto mapperDto;

    @Inject
    EntityManager em;

    public boolean addBuyersDistricts(BuyersDistrictsDto buyersDistrictsDto){
        Query checkQuery = em.createQuery("SELECT bd FROM BuyersDistricts bd WHERE bd.buyer.id = ?1 AND bd.district.id = ?2");
        checkQuery.setParameter(1, buyersDistrictsDto.buyerId);
        checkQuery.setParameter(2, buyersDistrictsDto.districtId);
        if(checkQuery.getResultList().size() != 0) // Запрещаем добавлять одному клиенту один и тот же район несколько раз
            return false;
        BuyersDistricts.addBuyersDistrict(mapperDto.BuyersDistrictsDtoToBuyersDistricts(buyersDistrictsDto));
        return true;
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
