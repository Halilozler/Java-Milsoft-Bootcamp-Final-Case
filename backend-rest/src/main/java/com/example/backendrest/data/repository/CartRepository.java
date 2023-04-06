package com.example.backendrest.data.repository;

import com.example.backendrest.data.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
