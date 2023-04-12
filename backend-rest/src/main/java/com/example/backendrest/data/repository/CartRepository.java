package com.example.backendrest.data.repository;

import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.CartProduct;
import com.example.backendrest.data.entity.CartStatus;
import com.example.backendrest.data.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
    @Query("select c from Cart c where c.users.usersId = :userId and c.cartStatus = :statusCode")
    public List<Cart> getListCartByUserId(@Param("userId") long userId, @Param("statusCode") CartStatus cartStatus);

    @Query("select c from Cart c where c.users.usersId = :userId and c.cartStatus = :statusCode")
    public Cart getCartByUserId(@Param("userId") long userId, @Param("statusCode") CartStatus cartStatus);
}
