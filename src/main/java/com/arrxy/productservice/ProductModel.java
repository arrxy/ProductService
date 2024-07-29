package com.arrxy.productservice;

import lombok.Data;

@Data
public class ProductModel {
    private String name;
    private String description;
    private double price;
    private int quantity;
}
