package com.arrxy.productservice.dtos;

import com.arrxy.productservice.models.Product;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class ProductResponseDto {
    private String name;
    private String description;
    private double price;

    public static ProductResponseDto fromProduct(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(product.getName());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setPrice(product.getPrice());
        return productResponseDto;
    }
}
