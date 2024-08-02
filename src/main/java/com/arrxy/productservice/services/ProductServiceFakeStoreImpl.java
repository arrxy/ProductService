package com.arrxy.productservice.services;

import com.arrxy.productservice.dtos.FakeStoreCreateProductRequestDto;
import com.arrxy.productservice.dtos.FakeStoreCreateProductResponseDto;
import com.arrxy.productservice.models.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceFakeStoreImpl implements ProductService {

    private RestTemplate restTemplate;
    public ProductServiceFakeStoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
//    @Override
//    public ArrayList<ProductResponseDto> getProducts() {
//        return restTemplate.getForEntity("https://fakestoreapi.com/products", new ParameterizedTypeReference<ArrayList<ProductResponseDto>>() {});
//    }

    public ArrayList<Product> getProducts() {
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                "https://fakestoreapi.com/products",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return (ArrayList<Product>) response.getBody();
    }

    @Override
    public String getProductById(String id) {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        HttpEntity<FakeStoreCreateProductRequestDto> request = new HttpEntity<>(FakeStoreCreateProductRequestDto.fromProduct(product));
        var res = Objects.requireNonNull(restTemplate.exchange(
                "https://fakestoreapi.com/products",
                HttpMethod.POST,
                request,
                FakeStoreCreateProductResponseDto.class
        ).getBody());
        return res.toProduct();
    }

    @Override
    public String deleteProduct() {
        return "products";
    }
}
