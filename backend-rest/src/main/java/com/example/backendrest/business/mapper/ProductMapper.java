package com.example.backendrest.business.mapper;

import com.example.backendrest.business.dto.ProductDto;
import com.example.backendrest.data.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDto productToProductDTO(Product product);
    Product productDTOtoProduct(ProductDto productDTO);
}
