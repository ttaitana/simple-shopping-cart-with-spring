package com.bomb0069.shopping.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/api/v1/product")
    public ProductListResponse getAllProduct() {

        ProductResponse productBalanceTrainingBicycle = new ProductResponse(1, "Balance Training Bicycle", 119.95, "/Balance_Training_Bicycle.png");
        ProductResponse product43PieceDinnerSet = new ProductResponse(2, "43 Piece dinner Set", 12.95, "/43_Piece_dinner_Set.png");

        ProductListResponse productListResponse = new ProductListResponse();
        productListResponse.addProduct(productBalanceTrainingBicycle);
        productListResponse.addProduct(product43PieceDinnerSet);

        return productListResponse;
    }
}
