package com.example.backendrest.business.dto;

import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.CartProduct;

import java.util.List;

public class CartDto {
    private long cartId;
    private String customerName;
    private String cardNumber;
    private Cart.CartStatus cartStatus;
    private List<CartProduct> cartProducts;

    public CartDto() {
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Cart.CartStatus getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(Cart.CartStatus cartStatus) {
        this.cartStatus = cartStatus;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
