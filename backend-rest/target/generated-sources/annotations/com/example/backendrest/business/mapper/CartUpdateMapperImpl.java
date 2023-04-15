package com.example.backendrest.business.mapper;

import com.example.backendrest.business.dto.CartUpdateDto;
import com.example.backendrest.data.entity.Cart;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T19:23:45+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Homebrew)"
)
public class CartUpdateMapperImpl implements CartUpdateMapper {

    @Override
    public CartUpdateDto cartToCartDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartUpdateDto cartUpdateDto = new CartUpdateDto();

        cartUpdateDto.setCartId( cart.getCartId() );
        cartUpdateDto.setCardNumber( cart.getCardNumber() );

        return cartUpdateDto;
    }

    @Override
    public Cart cartDtotoCart(CartUpdateDto cartUpdateDto) {
        if ( cartUpdateDto == null ) {
            return null;
        }

        Cart cart = new Cart();

        cart.setCartId( cartUpdateDto.getCartId() );
        cart.setCardNumber( cartUpdateDto.getCardNumber() );

        return cart;
    }
}
