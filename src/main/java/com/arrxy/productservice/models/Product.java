package com.arrxy.productservice.models;

import lombok.Data;

@Data
public class Product {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String imageUrl;
    private String category;
}
