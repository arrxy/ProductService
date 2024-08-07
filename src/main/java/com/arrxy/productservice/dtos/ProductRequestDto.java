package com.arrxy.productservice.dtos;

import com.arrxy.productservice.models.Product;
import lombok.Data;

@Data
public class ProductRequestDto {
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private String category;

    public Product toProduct() {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);
        product.setCategory(category);
        return product;
    }
}
