package com.example.backendrest.business.service.abstracts;

import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    BaseResponse<List<CategoryDto>> list();
}
