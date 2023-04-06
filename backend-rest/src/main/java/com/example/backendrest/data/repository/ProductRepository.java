package com.example.backendrest.data.repository;

import com.example.backendrest.data.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
