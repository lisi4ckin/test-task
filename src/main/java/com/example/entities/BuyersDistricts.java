package com.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Entity
public class BuyersDistricts extends PanacheEntity {

    @ManyToOne
    @JsonIgnore
    public Buyers buyer;

    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "districtid")
    public Districts district;


    @Transactional
    public static void addBuyersDistrict(BuyersDistricts buyersDistricts){
        buyersDistricts.persist();
    }

    @Transactional
    public static void deleteBuyersDistrict(Long id){
        BuyersDistricts.deleteById(id);
    }

    @Transactional
    public static void updateBuyersDistrict(BuyersDistricts buyersDistricts){
        BuyersDistricts buyersDistrictsToUpdate = BuyersDistricts.findById(buyersDistricts.id);
        setFields(buyersDistrictsToUpdate, buyersDistricts);
        buyersDistrictsToUpdate.persist();
    }

    public static List<BuyersDistricts> getBuyersDistricts(){
        return BuyersDistricts.listAll();
    }

    private static void setFields(BuyersDistricts in, BuyersDistricts out){
        in.district = Districts.findById(out.district.id);
        in.buyer = Buyers.findById(out.buyer.id);
    }
}
