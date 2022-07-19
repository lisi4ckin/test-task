package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;
import javax.transaction.Transactional;

@Entity
public class Districts extends PanacheEntity {
    public String districtName;
    public String description;

    @Transactional
    public void addDistrict(Districts district){
        district.persist();
    }

    @Transactional
    public void deleteDistrict(Long districtId){
        Districts district = Districts.findById(districtId);
        district.delete();
    }

    @Transactional
    public void updateDistrict(Long districtId){
        Districts district = Districts.findById(districtId);
        district.persist();
    }

}
