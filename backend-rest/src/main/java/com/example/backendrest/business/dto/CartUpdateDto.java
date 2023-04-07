package com.example.backendrest.business.dto;

import com.example.backendrest.data.entity.Cart;

public class CartUpdateDto {
    private long cartId;
    private String customerName;
    private String cardNumber;
    private Cart.CartStatus cartStatus;

    public Cart.CartStatus getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(Cart.CartStatus cartStatus) {
        this.cartStatus = Cart.CartStatus.COMPLETED;
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
}
