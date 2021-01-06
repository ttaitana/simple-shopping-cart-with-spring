package com.bomb0069.shopping.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductErrorResponse> productNotFoundHandler(ProductNotFoundException exception) {
        return new ResponseEntity<ProductErrorResponse>(new ProductErrorResponse(exception.getProductId()), HttpStatus.NOT_FOUND);
    }

}
