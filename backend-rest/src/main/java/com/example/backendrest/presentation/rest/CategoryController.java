package com.example.backendrest.presentation.rest;

import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.CategoryDto;
import com.example.backendrest.business.service.abstracts.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public BaseResponse<List<CategoryDto>> getCategoryList(){
        return categoryService.list();
    }
}
