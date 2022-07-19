package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Entity
public class Sellers extends PanacheEntity {
    public String sellerName;
    public String phone;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public Districts sellerDistrict;

    public Integer countFloors;
    public Integer floorNumber;
    public Float houseArea;
    public Float housePrice;


    public static List<Sellers> getAllSellers(){
        return Sellers.listAll();
    }

    @Transactional
    public static void addSeller(Sellers seller){
        seller.sellerDistrict = Districts.findById(seller.sellerDistrict.id);
        seller.persist();
    }

    @Transactional
    public static void deleteSeller(Long sellerId){
//        Sellers seller = Sellers.findById(sellerId);
//        seller.delete();
        Sellers.deleteById(sellerId);
    }

    @Transactional
    public static void updateSeller(Sellers seller){
        Sellers sellertoUpdate = Sellers.findById(seller.id);
        setFields(sellertoUpdate, seller);
        sellertoUpdate.persist();
    }

    private static void setFields(Sellers in, Sellers out){
        in.sellerName = out.sellerName;
        in.countFloors = out.countFloors;
        in.floorNumber = out.floorNumber;
        in.houseArea = out.houseArea;
        in.housePrice = out.housePrice;
        in.phone = out.phone;
        if(in.sellerDistrict != null)
            in.sellerDistrict = Districts.findById(out.sellerDistrict.id);
    }
}
