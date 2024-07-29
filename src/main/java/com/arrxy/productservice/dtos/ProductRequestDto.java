package com.arrxy.productservice.dtos;

import lombok.Data;

@Data
public class ProductRequestDto {
    private String name;
    private String description;
    private double price;
    private int quantity;
}
