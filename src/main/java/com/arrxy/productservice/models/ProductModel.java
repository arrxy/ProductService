package com.arrxy.productservice.models;

import lombok.Data;

@Data
public class ProductModel {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String imageUrl;
    private String category;
}
