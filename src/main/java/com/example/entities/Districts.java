package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.util.List;

@Entity
public class Districts extends PanacheEntity {
    public String districtName;
    public String description;

    public static List<Districts>getAllDistricts(){
        return Districts.listAll();
    }

    @Transactional
    public static void addDistrict(Districts district){
        district.persist();
    }

    @Transactional
    public static void deleteDistrict(Long districtId){
        Districts district = Districts.findById(districtId);
        district.delete();
    }

    @Transactional
    public static void updateDistrict(Long districtId){
        Districts district = Districts.findById(districtId);
        district.persist();
    }

}
