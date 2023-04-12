package com.example.backendrest.business.dto;

import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.CartProduct;
import com.example.backendrest.data.entity.CartStatus;
import com.example.backendrest.data.entity.Users;

import java.util.List;

public class CartDto {
    private long cartId;
    private Users users;
    private String cardNumber;
    private CartStatus cartStatus;

    public CartDto() {
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users user) {
        this.users = user;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        if(cardNumber.length() < 16){
            throw new IllegalArgumentException("Card number must be at least 16 characters long.");
        }
        this.cardNumber = cardNumber;
    }

    public CartStatus getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(CartStatus cartStatus) {
        this.cartStatus = cartStatus;
    }
}
