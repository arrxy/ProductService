package com.arrxy.productservice.services;

import com.arrxy.productservice.exceptions.CategoryNotPresentException;
import com.arrxy.productservice.exceptions.ProductNotFoundException;
import com.arrxy.productservice.models.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(String id) throws ProductNotFoundException;
    Product addProduct(Product product) throws CategoryNotPresentException;
    Product partialUpdateProduct(Product product, Long id) throws ProductNotFoundException;
    String deleteProduct();
}
