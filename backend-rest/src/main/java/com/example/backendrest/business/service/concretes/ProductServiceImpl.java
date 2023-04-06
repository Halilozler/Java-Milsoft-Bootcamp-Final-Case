package com.example.backendrest.business.service.concretes;

import com.example.backendrest.base.response.BaseResponse;
import com.example.backendrest.business.dto.CategoryDto;
import com.example.backendrest.business.dto.ProductDto;
import com.example.backendrest.business.mapper.ProductMapper;
import com.example.backendrest.business.service.abstracts.ProductService;
import com.example.backendrest.data.entity.Product;
import com.example.backendrest.data.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public BaseResponse<List<ProductDto>> getProductByCategoryId(long categoryId) {
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product product : productRepository.findProductsByCategoryId(categoryId)){
            productDtoList.add(ProductMapper.INSTANCE.productToProductDTO(product));
        }
        if(productDtoList.size() < 1){
            return BaseResponse.fail("product not found", 404);
        }
        return BaseResponse.Success(productDtoList, 200);
    }

    @Override
    public BaseResponse<ProductDto> getProductByProductId(long productId) {
        Optional<Product> optional = productRepository.findById(productId);
        if(optional.isPresent()){
            return BaseResponse.Success(ProductMapper.INSTANCE.productToProductDTO(optional.get()), 200);
        }
        return BaseResponse.fail("product not found", 404);
    }
}
