package com.example.backendrest.business.dto;

import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.CartStatus;

public class CartUpdateDto {
    private long cartId;
    private String cardNumber;

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
