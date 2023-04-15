package com.example.backendrest.business.mapper;

import com.example.backendrest.business.dto.CartProductGetDto;
import com.example.backendrest.business.dto.ProductDto;
import com.example.backendrest.data.entity.CartProduct;
import com.example.backendrest.data.entity.Product;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T19:23:45+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Homebrew)"
)
public class CartProductGetMapperImpl implements CartProductGetMapper {

    @Override
    public CartProductGetDto cartProductToCartProductGetDto(CartProduct cartProduct) {
        if ( cartProduct == null ) {
            return null;
        }

        CartProductGetDto cartProductGetDto = new CartProductGetDto();

        cartProductGetDto.setCartProductId( cartProduct.getCartProductId() );
        cartProductGetDto.setProduct( productToProductDto( cartProduct.getProduct() ) );
        cartProductGetDto.setSalesQuantity( cartProduct.getSalesQuantity() );

        return cartProductGetDto;
    }

    @Override
    public CartProduct cartProductGetDtotoCartProduct(CartProductGetDto cartProductGetDto) {
        if ( cartProductGetDto == null ) {
            return null;
        }

        CartProduct cartProduct = new CartProduct();

        cartProduct.setCartProductId( cartProductGetDto.getCartProductId() );
        cartProduct.setProduct( productDtoToProduct( cartProductGetDto.getProduct() ) );
        cartProduct.setSalesQuantity( cartProductGetDto.getSalesQuantity() );

        return cartProduct;
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
