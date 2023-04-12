package com.example.backendrest.business.dto;

import com.example.backendrest.data.entity.CartProduct;
import com.example.backendrest.data.entity.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

public class ProductDto {
    private long ProductId;
    private String productName;
    private double salesPrice;

    public ProductDto() {
    }

    public ProductDto(long productId, String productName, double salesPrice) {
        ProductId = productId;
        this.productName = productName;
        this.salesPrice = salesPrice;
    }

    public long getProductId() {
        return ProductId;
    }

    public void setProductId(long productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }
}
