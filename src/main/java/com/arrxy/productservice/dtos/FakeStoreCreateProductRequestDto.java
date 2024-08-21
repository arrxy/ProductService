package com.arrxy.productservice.dtos;

import com.arrxy.productservice.models.Product;
import lombok.Data;

@Data
public class FakeStoreCreateProductRequestDto {
    private Integer id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
//    private String category;

    public static FakeStoreCreateProductRequestDto fromProduct(Product product) {
        FakeStoreCreateProductRequestDto fakeStoreCreateProductRequestDto = new FakeStoreCreateProductRequestDto();
        fakeStoreCreateProductRequestDto.setTitle(product.getName());
        fakeStoreCreateProductRequestDto.setDescription(product.getDescription());
        fakeStoreCreateProductRequestDto.setPrice(product.getPrice());
        fakeStoreCreateProductRequestDto.setImageUrl(product.getImageUrl());
//        fakeStoreCreateProductRequestDto.setCategory(product.getCategory());
        return fakeStoreCreateProductRequestDto;
    }
}
