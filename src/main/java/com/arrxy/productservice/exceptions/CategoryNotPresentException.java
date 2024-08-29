package com.arrxy.productservice.exceptions;

public class CategoryNotPresentException extends Exception {
    public CategoryNotPresentException() {
        super("Categgory Not found");
    }
}
