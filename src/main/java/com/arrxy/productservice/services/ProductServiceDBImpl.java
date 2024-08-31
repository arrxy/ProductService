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
public class ProductServiceDBImpl implements ProductService {

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
        product.setCategory(getOrSetProductCategory(categoryName));
        return productRepository.save(product);
    }

    public Product partialUpdateProduct(Product product, Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException();
        }
        Product productFromDB = productOptional.get();
        product.setId(id);
        if (product.getName() != null) {
            productFromDB.setName(product.getName());
        }
        if (product.getPrice() != null) {
            productFromDB.setPrice(product.getPrice());
        }
        if (product.getCategory() != null && product.getCategory().getName() != null) {
            productFromDB.setCategory(getOrSetProductCategory(product.getCategory().getName()));
        }
        if (product.getDescription() != null) {
            productFromDB.setDescription(product.getDescription());
        }
        if (product.getQuantity() != null) {
            productFromDB.setQuantity(product.getQuantity());
        }
        if (product.getQuantity() != null) {
            productFromDB.setQuantity(product.getQuantity());
        }
        return productRepository.save(productFromDB);
    }

    private Category getOrSetProductCategory(String categoryName) {
        Optional<Category> category = categoryRepository.findCategoryByName(categoryName);
        if (category.isEmpty()) {
            Category newCategory = new Category();
            newCategory.setName(categoryName);
            return categoryRepository.save(newCategory);
        }
        return category.get();
    }

    @Override
    public String deleteProduct() {
        return "";
    }
}
