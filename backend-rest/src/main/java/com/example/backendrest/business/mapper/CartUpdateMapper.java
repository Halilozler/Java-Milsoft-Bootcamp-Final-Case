package com.example.backendrest.business.mapper;

import com.example.backendrest.business.dto.CartDto;
import com.example.backendrest.business.dto.CartUpdateDto;
import com.example.backendrest.data.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartUpdateMapper {
    CartUpdateMapper INSTANCE = Mappers.getMapper(CartUpdateMapper.class);
    CartUpdateDto cartToCartDto(Cart cart);
    Cart cartDtotoCart(CartUpdateDto cartUpdateDto);
}
