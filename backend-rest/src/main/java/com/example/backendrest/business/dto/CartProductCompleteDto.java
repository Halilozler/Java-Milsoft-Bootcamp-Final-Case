package com.example.backendrest.business.dto;

import com.example.backendrest.data.entity.CartStatus;
import com.example.backendrest.data.entity.Users;

import java.util.Date;
import java.util.List;

public class CartProductCompleteDto {
    private String cardNumber;
    private Date createdDate;
    private List<CartProductGetDto> cartProductGetDtoList;

    public CartProductCompleteDto() {
    }

    public CartProductCompleteDto(List<CartProductGetDto> cartProductGetDtoList) {
        this.cartProductGetDtoList = cartProductGetDtoList;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<CartProductGetDto> getCartProductGetDtoList() {
        return cartProductGetDtoList;
    }

    public void setCartProductGetDtoList(List<CartProductGetDto> cartProductGetDtoList) {
        this.cartProductGetDtoList = cartProductGetDtoList;
    }
}
