package com.arrxy.productservice.controllers;
import com.arrxy.productservice.dtos.ProductRequestDto;
import com.arrxy.productservice.dtos.ProductResponseDto;
import com.arrxy.productservice.exceptions.CategoryNotPresentException;
import com.arrxy.productservice.exceptions.ProductNotFoundException;
import com.arrxy.productservice.models.Product;
import com.arrxy.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController(@Qualifier("productServiceDBImpl") ProductService productService) {
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
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto productRequestDto) throws CategoryNotPresentException {
        return ProductResponseDto.fromProduct(productService.addProduct(productRequestDto.toProduct()));
    }

    @PatchMapping("{id}/update")
    public ProductResponseDto updateProduct(@RequestBody ProductRequestDto product, @PathVariable("id") Long id) throws ProductNotFoundException {
        return ProductResponseDto.fromProduct(productService.partialUpdateProduct(product.toProduct(), id));
    }

    @PutMapping("/delete")
    public String deleteProduct() {
        return "products";
    }
}
