package com.example.entities;

import com.example.services.SellerService;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Sellers extends PanacheEntity {
    public String sellerName;
    public String phone;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
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
        seller.persist();
    }

    @Transactional
    public static void deleteSeller(Long sellerId){
        Sellers seller = Sellers.findById(sellerId);
        seller.delete();
    }

    @Transactional
    public static void updateSeller(Long sellerId){
        Sellers seller = Sellers.findById(sellerId);
        seller.persist();
    }
}
