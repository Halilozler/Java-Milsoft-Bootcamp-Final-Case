package com.example.backendrest.business.mapper;

import com.example.backendrest.business.dto.CartDto;
import com.example.backendrest.data.entity.Cart;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T19:23:45+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Homebrew)"
)
public class CartMapperImpl implements CartMapper {

    @Override
    public CartDto cartToCartDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDto cartDto = new CartDto();

        cartDto.setCartId( cart.getCartId() );
        cartDto.setCardNumber( cart.getCardNumber() );
        cartDto.setCartStatus( cart.getCartStatus() );

        return cartDto;
    }

    @Override
    public Cart cartDtotoCart(CartDto cartDto) {
        if ( cartDto == null ) {
            return null;
        }

        Cart cart = new Cart();

        cart.setCartId( cartDto.getCartId() );
        cart.setCardNumber( cartDto.getCardNumber() );
        cart.setCartStatus( cartDto.getCartStatus() );

        return cart;
    }
}
