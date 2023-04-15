package com.example.backendrest.business.mapper;

import com.example.backendrest.business.dto.CartDto;
import com.example.backendrest.business.dto.CartProductDto;
import com.example.backendrest.business.dto.ProductDto;
import com.example.backendrest.data.entity.Cart;
import com.example.backendrest.data.entity.CartProduct;
import com.example.backendrest.data.entity.Product;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T19:23:45+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Homebrew)"
)
public class CartProductMapperImpl implements CartProductMapper {

    @Override
    public CartProductDto cartProductTocartProductDto(CartProduct cartProduct) {
        if ( cartProduct == null ) {
            return null;
        }

        CartProductDto cartProductDto = new CartProductDto();

        cartProductDto.setCartProductId( cartProduct.getCartProductId() );
        cartProductDto.setCart( cartToCartDto( cartProduct.getCart() ) );
        cartProductDto.setProduct( productToProductDto( cartProduct.getProduct() ) );
        cartProductDto.setSalesQuantity( cartProduct.getSalesQuantity() );

        return cartProductDto;
    }

    @Override
    public CartProduct cartProductDtoTocartProduct(CartProductDto cartProductDto) {
        if ( cartProductDto == null ) {
            return null;
        }

        CartProduct cartProduct = new CartProduct();

        cartProduct.setCartProductId( cartProductDto.getCartProductId() );
        cartProduct.setCart( cartDtoToCart( cartProductDto.getCart() ) );
        cartProduct.setProduct( productDtoToProduct( cartProductDto.getProduct() ) );
        cartProduct.setSalesQuantity( cartProductDto.getSalesQuantity() );

        return cartProduct;
    }

    protected CartDto cartToCartDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDto cartDto = new CartDto();

        cartDto.setCartId( cart.getCartId() );
        cartDto.setCardNumber( cart.getCardNumber() );
        cartDto.setCartStatus( cart.getCartStatus() );

        return cartDto;
    }

    protected ProductDto productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProductId( product.getProductId() );
        productDto.setProductName( product.getProductName() );
        productDto.setSalesPrice( product.getSalesPrice() );

        return productDto;
    }

    protected Cart cartDtoToCart(CartDto cartDto) {
        if ( cartDto == null ) {
            return null;
        }

        Cart cart = new Cart();

        cart.setCartId( cartDto.getCartId() );
        cart.setCardNumber( cartDto.getCardNumber() );
        cart.setCartStatus( cartDto.getCartStatus() );

        return cart;
    }

    protected Product productDtoToProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductId( productDto.getProductId() );
        product.setProductName( productDto.getProductName() );
        product.setSalesPrice( productDto.getSalesPrice() );

        return product;
    }
}
