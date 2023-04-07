package com.example.backendrest.business.service.abstracts;

import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.CartProductDto;

public interface CartProductService {
    BaseResponse<CartProductDto> removeCartProduct(long cartId, long productId);
    BaseResponse<CartProductDto> addCartProduct(long cartId, long productId);
}