package com.example.backendrest.business.dto;

import com.example.backendrest.data.entity.CartProduct;
import com.example.backendrest.data.entity.Category;

import java.util.List;

public class ProductDto {
    private long ProductId;
    private String productName;
    private double salesPrice;
    private Category category;
    private List<CartProduct> cartProducts;

    public ProductDto() {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
