package com.arrxy.productservice.dtos;

import com.arrxy.productservice.models.Category;
import com.arrxy.productservice.models.Product;
import lombok.Data;

@Data
public class ProductRequestDto {
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;

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
