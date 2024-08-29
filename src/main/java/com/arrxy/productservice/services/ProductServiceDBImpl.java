package com.arrxy.productservice.services;

import com.arrxy.productservice.exceptions.CategoryNotPresentException;
import com.arrxy.productservice.exceptions.ProductNotFoundException;
import com.arrxy.productservice.models.Category;
import com.arrxy.productservice.models.Product;
import com.arrxy.productservice.repository.CategoryRepository;
import com.arrxy.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("productServiceDBImpl")
public class ProductServiceDBImpl implements ProductService{

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductServiceDBImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) throws ProductNotFoundException {
        Long idLong = Long.parseLong(id);
        Optional<Product> product = productRepository.findById(idLong);
        if (product.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return product.get();
    }

    @Override
    public Product addProduct(Product product) throws CategoryNotPresentException {
        String categoryName = product.getCategory().getName();
        if (categoryName == null) {
            throw new CategoryNotPresentException();
        }
        Optional<Category> category = categoryRepository.findCategoryByName(categoryName);
        if (category.isEmpty()) {
            category = Optional.ofNullable(categoryRepository.save(product.getCategory()));
        }
        product.setCategory(category.get());
        return productRepository.save(product);
    }

    @Override
    public String deleteProduct() {
        return "";
    }
}
