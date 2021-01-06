
package com.bomb0069.shopping.product;

public class ProductResponse {

    private Integer id;
    private String productName;
    private Double productPrice;
    private String productImage;

    public ProductResponse() {
    }

    public ProductResponse(Integer id, String productName, Double productPrice, String productImage) {
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

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
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

    @Override
    public boolean equals(Object product) {

        if (product == this)
            return true;

        if (!(product instanceof ProductResponse))
            return false;

        ProductResponse productResponse = (ProductResponse) product;

        if (productResponse.getId() == this.getId())
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "id: " + id + "\n"
                + "productName: " + productName + "\n"
                + "productPrice: " + productPrice + "\n"
                + "productImage: " + productImage;
    }

}
