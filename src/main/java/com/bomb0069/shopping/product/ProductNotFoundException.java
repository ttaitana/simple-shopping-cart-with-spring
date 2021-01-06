package com.bomb0069.shopping.product;

public class ProductNotFoundException extends RuntimeException {
    public Integer getProductId() {
        return productId;
    }

    private final Integer productId;

    public ProductNotFoundException(Integer productId) {
        this.productId = productId;
    }
}
