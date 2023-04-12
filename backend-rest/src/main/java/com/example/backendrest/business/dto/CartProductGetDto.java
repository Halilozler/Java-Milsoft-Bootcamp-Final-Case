package com.example.backendrest.business.dto;

public class CartProductGetDto {
    private long cartProductId;
    private ProductDto product;
    private int salesQuantity;

    public CartProductGetDto() {
    }

    public CartProductGetDto(long cartProductId, ProductDto product, int salesQuantity) {
        this.cartProductId = cartProductId;
        this.product = product;
        this.salesQuantity = salesQuantity;
    }

    public long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }
}
