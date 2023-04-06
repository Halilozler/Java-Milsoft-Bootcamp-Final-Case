package com.example.backendrest.data.repository;

import com.example.backendrest.data.entity.CartProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends CrudRepository<CartProduct, Long> {
}
