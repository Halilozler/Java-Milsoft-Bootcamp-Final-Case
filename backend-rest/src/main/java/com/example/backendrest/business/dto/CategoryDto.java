package com.example.backendrest.business.dto;

import com.example.backendrest.data.entity.Product;

import java.util.List;

public class CategoryDto {
    private long categoryId;
    private String categoryName;
    private List<Product> productList;

    public CategoryDto() {
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
