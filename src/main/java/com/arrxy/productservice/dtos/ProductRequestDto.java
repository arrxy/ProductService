package com.arrxy.productservice.dtos;

import com.arrxy.productservice.models.ProductModel;
import lombok.Data;

@Data
public class ProductRequestDto {
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private String category;

    public ProductModel toProduct() {
        ProductModel productModel = new ProductModel();
        productModel.setName(name);
        productModel.setDescription(description);
        productModel.setPrice(price);
        productModel.setImageUrl(imageUrl);
        productModel.setCategory(category);
        return productModel;
    }
}
