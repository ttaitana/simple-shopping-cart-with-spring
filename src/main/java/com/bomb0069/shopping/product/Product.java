package com.bomb0069.shopping.product;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private Integer id;
    private String productName;
    private Double productPrice;
    private String productImage;

    public Product() {
    }

    public Product(Integer id, String productName, Double productPrice, String productImage) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

}
