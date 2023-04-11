package com.example.backendrest.business.mapper;

import com.example.backendrest.business.dto.CartDto;
import com.example.backendrest.business.dto.CartProductDto;
import com.example.backendrest.business.dto.CartProductGetDto;
import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.CartProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartProductGetMapper {
    CartProductGetMapper INSTANCE = Mappers.getMapper(CartProductGetMapper.class);
    CartProductGetDto cartProductToCartProductGetDto(CartProduct cartProduct);
    CartProduct cartProductGetDtotoCartProduct(CartProductGetDto cartProductGetDto);
}
