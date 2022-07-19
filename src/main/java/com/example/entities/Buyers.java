package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.text.ChoiceFormat;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Buyers extends PanacheEntity {
    public String buyerName;
    public String buyerPhone;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    public Set<Districts> buyerDistricts = new HashSet<>();

    public Float houseAreaGTE;
    public Float houseAreaLTE;

    public Float maxPrice;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    public Set<Filters> buyerFilters = new HashSet<>();
}
