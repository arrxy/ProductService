package com.arrxy.productservice.repository;

import com.arrxy.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();
}
