package com.example.backendrest.business.mapper;
import com.example.backendrest.business.dto.CartProductDto;
import com.example.backendrest.data.entity.CartProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CartProductMapper {
    CartProductMapper INSTANCE = Mappers.getMapper(CartProductMapper.class);
    CartProductDto cartProductTocartProductDto(CartProduct cartProduct);
    CartProduct cartProductDtoTocartProduct(CartProductDto cartProductDto);
}
