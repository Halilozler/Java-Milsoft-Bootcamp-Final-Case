package com.example.backendrest.business.service.abstracts;

import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.CartProductCompleteDto;
import com.example.backendrest.business.dto.CartProductDto;
import com.example.backendrest.business.dto.CartProductGetDto;

import java.util.List;

public interface CartProductService {
    BaseResponse<CartProductDto> removeCartProduct(long productId, long userId);
    BaseResponse<Boolean> removeAllCartProduct(long userId);
    BaseResponse<Boolean> removeCartQuantityProduct(long productId, long userId);
    BaseResponse<CartProductDto> addCartProduct(long productId, long userId, int salesQuantity);
    BaseResponse<List<CartProductCompleteDto>> getCompleteProductById(long userId);
    BaseResponse<List<CartProductGetDto>> getNewProductById(long userId);
}
