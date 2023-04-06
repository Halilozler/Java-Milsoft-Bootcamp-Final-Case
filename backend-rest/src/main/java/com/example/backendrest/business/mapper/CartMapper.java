package com.example.backendrest.business.mapper;
import com.example.backendrest.business.dto.CartDto;
import com.example.backendrest.business.dto.ProductDto;
import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);
    CartDto cartToCartDto(Cart cart);
    Cart cartDtotoCart(CartDto cartDto);
}
