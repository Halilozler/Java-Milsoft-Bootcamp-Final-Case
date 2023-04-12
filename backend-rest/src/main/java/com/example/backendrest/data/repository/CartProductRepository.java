package com.example.backendrest.data.repository;

import com.example.backendrest.business.dto.CartProductCompleteDto;
import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.CartProduct;
import com.example.backendrest.data.entity.CartStatus;
import com.example.backendrest.data.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductRepository extends CrudRepository<CartProduct, Long> {
    @Query("select cp FROM CartProduct cp WHERE cp.cart.cartId = :cartId and cp.product.ProductId = :productId")
    CartProduct findCartProduct(@Param("cartId") long cartId, @Param("productId") long productId);
    @Modifying
    @Query("DELETE FROM CartProduct cp WHERE cp.cartProductId = :cartProductId")
    void writeDelete(@Param("cartProductId") long cartProductId);

    @Query("select cp from CartProduct cp where cp.cart.cartId = :cartId and cp.cart.cartStatus = :status")
    public List<CartProduct> getCartProduct(@Param("cartId") long cartId, @Param("status") CartStatus status);

    @Query("select cp from CartProduct cp where cp.cart.cartId = :cartId")
    public List<CartProduct> getCartProductByCartId(@Param("cartId") long cartId);

    /*
    @Query("select cp from CartProduct cp where cp.cart.userId = :userId and cp.cart.cartStatus = Cart.CartStatus.COMPLETED order by cp.cart.createdDate desc")
    public List<CartProduct> getCartProductComplete(@Param("userId") long userId);
    */
}
