package com.arrxy.productservice.services;

import com.arrxy.productservice.models.Product;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> getProducts();
    String getProductById(String id);
    Product addProduct(Product product);
    String deleteProduct();
}
