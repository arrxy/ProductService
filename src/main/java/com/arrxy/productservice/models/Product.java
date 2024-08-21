package com.arrxy.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String imageUrl;
    @ManyToOne
    private Category category;
}
