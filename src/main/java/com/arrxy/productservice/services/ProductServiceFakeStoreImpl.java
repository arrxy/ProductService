package com.arrxy.productservice.services;

import com.arrxy.productservice.dtos.FakeStoreCreateProductResponseDto;
import com.arrxy.productservice.dtos.ProductResponseDto;
import com.arrxy.productservice.models.ProductModel;
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

    public ArrayList<ProductModel> getProducts() {
        ResponseEntity<List<ProductModel>> response = restTemplate.exchange(
                "https://fakestoreapi.com/products",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return (ArrayList<ProductModel>) response.getBody();
    }

    @Override
    public String getProductById(String id) {
        return "products";
    }

    @Override
    public ProductModel addProduct(ProductModel product) {
        HttpEntity<ProductModel> request = new HttpEntity<>(product);
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
