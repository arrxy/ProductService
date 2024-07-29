package com.arrxy.productservice.services;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceFakeStoreImpl implements ProductService {
    @Override
    public String getProducts() {
        return "products";
    }

    @Override
    public String getProductById(String id) {
        return "products";
    }

    @Override
    public String addProduct() {
        return "products";
    }

    @Override
    public String deleteProduct() {
        return "products";
    }
}
