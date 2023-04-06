package com.example.backendrest.data.repository;

import com.example.backendrest.data.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
