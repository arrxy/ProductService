package com.arrxy.productservice.controllers;
import com.arrxy.productservice.dtos.ProductRequestDto;
import com.arrxy.productservice.dtos.ProductResponseDto;
import com.arrxy.productservice.models.Product;
import com.arrxy.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<ProductResponseDto> getProducts() {
        return productService.getProducts().stream().map(ProductResponseDto::fromProduct).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id, @RequestParam String name) {
        return "products";
    }

    @PostMapping
    public Product addProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.addProduct(productRequestDto.toProduct());
    }

    @PutMapping("/delete")
    public String deleteProduct() {
        return "products";
    }
}
