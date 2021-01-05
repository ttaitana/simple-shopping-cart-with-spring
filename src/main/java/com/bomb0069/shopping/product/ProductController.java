package com.bomb0069.shopping.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/api/v1/product")
    public String getAllProduct() {
        return "Hello";
    }
}
