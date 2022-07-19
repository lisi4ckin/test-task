package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Buyers extends PanacheEntity {
    public String buyerName;
    public String buyerPhone;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Districts> buyerDistricts;

    public Float houseAreaGTE;
    public Float houseAreaLTE;

    public Float maxPrice;

    public Integer buyerFilters;


    @Transactional
    public static void addBuyer(Buyers buyer){
        buyer.buyerDistricts.replaceAll(districts -> Districts.findById(districts.id));
        buyer.persist();
    }

    @Transactional
    public static void deleteBuyer(Long buyerId){
        Buyers.deleteById(buyerId);
    }

    @Transactional
    public static void updateBuyer(Buyers buyer){
        Buyers buyerToUpdate = Buyers.findById(buyer.id);
        setFields(buyerToUpdate, buyer);
        buyerToUpdate.persist();
    }

    private static void setFields(Buyers in, Buyers out){
        in.buyerDistricts = out.buyerDistricts;
        in.buyerFilters = out.buyerFilters;
        in.buyerName = out.buyerName;
        in.buyerPhone = out.buyerPhone;
        in.houseAreaGTE = out.houseAreaGTE;
        in.houseAreaLTE = out.houseAreaLTE;
        in.maxPrice = out.maxPrice;
    }
}
