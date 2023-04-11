package com.example.backendrest.data.repository;

import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.CartProduct;
import com.example.backendrest.data.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

}
