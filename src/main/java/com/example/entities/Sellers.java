package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sellers extends PanacheEntity {
    public String sellerName;
    public String phone;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    public Set<Districts> sellerDistrict = new HashSet<>();

    public Integer countFloors;
    public Integer floorNumber;
    public Float houseArea;
    public Float housePrice;


    @Transactional
    public void addSeller(Sellers seller){
        seller.persist();
    }

    @Transactional
    public void deleteSeller(Long sellerId){
        Sellers seller = Sellers.findById(sellerId);
        seller.delete();
    }

    @Transactional
    public void updateSeller(Long sellerId){
        Sellers seller = Sellers.findById(sellerId);
        seller.persist();
    }
}
