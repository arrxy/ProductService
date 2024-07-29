package com.arrxy.productservice.dtos;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class ProductResponseDto {
    private String name;
    private String description;
    private double price;
    private int quantity;

    public ProductResponseDto() {
    }

    public ProductResponseDto(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

}
