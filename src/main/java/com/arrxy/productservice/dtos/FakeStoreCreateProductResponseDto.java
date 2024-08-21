package com.arrxy.productservice.dtos;

import com.arrxy.productservice.models.Product;
import lombok.Data;

@Data
public class FakeStoreCreateProductResponseDto {
    private Integer id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
//    private String category;

    public Product toProduct() {
        Product product = new Product();
        product.setName(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);
//        product.setCategory(category);
        return product;
    }
}
