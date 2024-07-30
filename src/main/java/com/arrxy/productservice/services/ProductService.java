package com.arrxy.productservice.services;

import com.arrxy.productservice.dtos.ProductResponseDto;
import com.arrxy.productservice.models.ProductModel;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<ProductModel> getProducts();
    String getProductById(String id);
    ProductModel addProduct(ProductModel product);
    String deleteProduct();
}
