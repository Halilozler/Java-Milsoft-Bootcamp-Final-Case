package com.example.backendrest.business.dto;

import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.Product;

public class CartProductDto {
    private long cartProductId;
    private CartDto cart;
    private ProductDto product;
    private int salesQuantity;

    public long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public CartDto getCart() {
        return cart;
    }

    public void setCart(CartDto cart) {
        this.cart = cart;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }
}
