
package com.bomb0069.shopping.product;

import java.util.ArrayList;
import java.util.List;

public class ProductListResponse {

    private List<ProductResponse> products = new ArrayList<>();

    public Integer getTotal() {
        return products.size();
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void addProduct(ProductResponse product) {
        products.add(product);
    }
}



