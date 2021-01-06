package com.bomb0069.shopping.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/api/v1/product")
    public ProductListResponse getAllProduct() {
        ProductListResponse productListResponse = new ProductListResponse();
        Iterable<Product> allProducts = productRepository.findAll();
        for (Product product: allProducts) {
            productListResponse.addProduct(createProductResponse(product));
        }
        return productListResponse;
    }

    private ProductResponse createProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getProductName(), product.getProductPrice(), product.getImageUrl());
    }
}
