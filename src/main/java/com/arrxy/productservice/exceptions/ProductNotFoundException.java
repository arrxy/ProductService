package com.arrxy.productservice.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException() {
        super("Product Not found");
    }
}
