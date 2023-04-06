package com.example.backendrest.business.service.concretes;

import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.CategoryDto;
import com.example.backendrest.business.mapper.CategoryMapper;
import com.example.backendrest.business.service.abstracts.CategoryService;
import com.example.backendrest.data.entity.Category;
import com.example.backendrest.data.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public BaseResponse<List<CategoryDto>> list() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for(Category category: categoryRepository.findAll()){
            categoryDtoList.add(CategoryMapper.INSTANCE.categoryToCategoryDto(category));
        }
        BaseResponse<List<CategoryDto>> response = BaseResponse.Success(categoryDtoList, 200);
        return response;
    }
}
