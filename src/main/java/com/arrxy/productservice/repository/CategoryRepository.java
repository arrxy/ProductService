package com.arrxy.productservice.repository;

import com.arrxy.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    Category save(Category category);

    Optional<Category> findCategoryByName(String name);
}
