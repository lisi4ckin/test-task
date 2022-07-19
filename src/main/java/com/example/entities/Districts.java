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
        Districts.deleteById(districtId);
    }

    @Transactional
    public static void updateDistrict(Districts district){
        Districts districtToUpdate = Districts.findById(district.id);
        setFields(districtToUpdate, district);
        districtToUpdate.persist();
    }

    private static void setFields(Districts in, Districts out){
        in.description = out.description;
        in.districtName = out.districtName;
    }

}
