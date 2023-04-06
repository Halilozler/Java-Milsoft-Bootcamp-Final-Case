package com.example.backendrest.presentation.rest;

import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.CategoryDto;
import com.example.backendrest.business.dto.ProductDto;
import com.example.backendrest.business.service.abstracts.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public BaseResponse<ProductDto> productByProductId(@PathVariable("productId") long productId){
        return productService.getProductByProductId(productId);
    }

    @GetMapping("/products/{categoryId}")
    public BaseResponse<List<ProductDto>> productByCategoryId(@PathVariable("categoryId") long categoryId){
        return productService.getProductByCategoryId(categoryId);
    }
}
