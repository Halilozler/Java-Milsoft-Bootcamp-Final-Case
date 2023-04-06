package com.example.backendrest.business.service.abstracts;

import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.ProductDto;

import java.util.List;

public interface ProductService {
    BaseResponse<List<ProductDto>> getProductByCategoryId(long categoryId);
    BaseResponse<ProductDto>  getProductByProductId(long productId);
}
