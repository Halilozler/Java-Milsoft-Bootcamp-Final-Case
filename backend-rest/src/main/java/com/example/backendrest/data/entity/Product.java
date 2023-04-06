package com.example.backendrest.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ProductId;
    private String productName;
    private double salesPrice;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Category category;
    public Product() {}

    public Product(String productName, double salesPrice, Category category) {
        this.productName = productName;
        this.salesPrice = salesPrice;
        this.category = category;
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
}
