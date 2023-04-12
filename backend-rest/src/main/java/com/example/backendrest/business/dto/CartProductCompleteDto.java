package com.example.backendrest.business.dto;

import java.util.List;

public class CartProductCompleteDto {
    private CartDto cartDto;
    private List<CartProductGetDto> cartProductGetDtoList;

    public CartProductCompleteDto() {
    }

    public CartProductCompleteDto(CartDto cartDto, List<CartProductGetDto> cartProductGetDtoList) {
        this.cartDto = cartDto;
        this.cartProductGetDtoList = cartProductGetDtoList;
    }

    public CartDto getCartDto() {
        return cartDto;
    }

    public void setCartDto(CartDto cartDto) {
        this.cartDto = cartDto;
    }

    public List<CartProductGetDto> getCartProductGetDtoList() {
        return cartProductGetDtoList;
    }

    public void setCartProductGetDtoList(List<CartProductGetDto> cartProductGetDtoList) {
        this.cartProductGetDtoList = cartProductGetDtoList;
    }
}
