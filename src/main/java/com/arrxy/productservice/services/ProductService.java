package com.arrxy.productservice.services;

public interface ProductService {
    String getProducts();
    String getProductById(String id);
    String addProduct();
    String deleteProduct();
}
