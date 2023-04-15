package com.example.backendrest.business.mapper;

import com.example.backendrest.business.dto.ProductDto;
import com.example.backendrest.data.entity.Product;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T19:23:45+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Homebrew)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto productToProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProductId( product.getProductId() );
        productDto.setProductName( product.getProductName() );
        productDto.setSalesPrice( product.getSalesPrice() );

        return productDto;
    }

    @Override
    public Product productDTOtoProduct(ProductDto productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductId( productDTO.getProductId() );
        product.setProductName( productDTO.getProductName() );
        product.setSalesPrice( productDTO.getSalesPrice() );

        return product;
    }
}
