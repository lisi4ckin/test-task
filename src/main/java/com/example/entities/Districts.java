package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;

@Entity
public class Districts extends PanacheEntity {
    public String districtName;
    public String description;
}
