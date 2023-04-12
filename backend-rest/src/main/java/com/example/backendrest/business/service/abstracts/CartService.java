package com.example.backendrest.business.service.abstracts;

import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.CartDto;
import com.example.backendrest.business.dto.CartProductDto;
import com.example.backendrest.business.dto.CartUpdateDto;
import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.Users;

import java.util.List;

public interface CartService {
    BaseResponse<Cart> getCart(long userId);
    BaseResponse<Cart> addCart(CartDto cartDto, Users users);
    BaseResponse<CartDto> updateCart(CartUpdateDto cartUpdateDto, long userId);
    BaseResponse<Boolean> setCartCompleted(long userId);
}
