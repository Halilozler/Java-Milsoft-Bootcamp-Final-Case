package com.example.backendrest.business.service.abstracts;

import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.CartDto;
import com.example.backendrest.business.dto.CartUpdateDto;
import com.example.backendrest.data.entity.Cart;

public interface CartService {
    BaseResponse<CartDto> getCart(long cartId);
    BaseResponse<Cart> addCart(CartDto cartDto);
    BaseResponse<CartDto> updateCart(CartUpdateDto cartUpdateDto);
}
