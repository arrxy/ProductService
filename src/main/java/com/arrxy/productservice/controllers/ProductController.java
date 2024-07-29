package com.arrxy.productservice.controllers;
import com.arrxy.productservice.dtos.ProductRequestDto;
import com.arrxy.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ArrayList<String> getProducts() {
        String products = "products";
        ArrayList<String> productsList = new ArrayList<>();
        productsList.add(products);
        return productsList;
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id, @RequestParam String name) {
        return "products";
    }

    @PostMapping
    public String addProduct(@RequestBody ProductRequestDto productRequestDto) {
        return "products";
    }

    @PutMapping("/delete")
    public String deleteProduct() {
        return "products";
    }
}
