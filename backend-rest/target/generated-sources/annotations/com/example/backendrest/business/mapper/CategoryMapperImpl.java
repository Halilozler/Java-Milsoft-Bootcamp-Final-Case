package com.example.backendrest.business.mapper;

import com.example.backendrest.business.dto.CategoryDto;
import com.example.backendrest.data.entity.Category;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T19:23:45+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Homebrew)"
)
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCategoryId( category.getCategoryId() );
        categoryDto.setCategoryName( category.getCategoryName() );

        return categoryDto;
    }

    @Override
    public Category categoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( categoryDto.getCategoryId() );
        category.setCategoryName( categoryDto.getCategoryName() );

        return category;
    }
}
