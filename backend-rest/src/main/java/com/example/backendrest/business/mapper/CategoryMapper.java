package com.example.backendrest.business.mapper;

import com.example.backendrest.business.dto.CategoryDto;
import com.example.backendrest.data.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    CategoryDto categoryToCategoryDto(Category category);
    Category categoryDtoToCategory(CategoryDto categoryDto);
}
