package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Buyers extends PanacheEntity {
    public String buyerName;
    public String buyerPhone;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    public List<BuyersDistricts> buyerDistricts;

    public Float houseAreaGTE;
    public Float houseAreaLTE;

    public Float maxPrice;

    public Integer buyerFilters;


    @Transactional
    public static Long addBuyer(Buyers buyer){
//        buyer.buyerDistricts.replaceAll(districts -> Districts.findById(districts.id));
        buyer.persist();
        return buyer.id;
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
        /*if((out.buyerDistricts != null)&&(out.buyerDistricts.size() > 0)) {
            List<BuyersDistricts> districtsList = new ArrayList<>();
            for (BuyersDistricts buyersDistricts : out.buyerDistricts) {
                BuyersDistricts buydis = BuyersDistricts.findById(buyersDistricts.id);
                buydis.district = Districts.findById(buy)
//                districtsList.add(Districts.findById(buyersDistricts.district.id));

            }
            in.buyerDistricts = districtsList;
        }*/
    }
}
