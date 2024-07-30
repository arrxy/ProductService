package com.arrxy.productservice.dtos;

import com.arrxy.productservice.models.ProductModel;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class ProductResponseDto {
    private String name;
    private String description;
    private double price;

    public static ProductResponseDto fromProduct(ProductModel productModel) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(productModel.getName());
        productResponseDto.setDescription(productModel.getDescription());
        productResponseDto.setPrice(productModel.getPrice());
        return productResponseDto;
    }
}
