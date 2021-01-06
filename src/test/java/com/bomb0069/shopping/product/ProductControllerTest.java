package com.bomb0069.shopping.product;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired ProductRepository repository;

    @PostConstruct
    public void initialDataForTesting() {
        Product productBalanceTrainingBicycle = new Product(1, "Balance Training Bicycle", 119.95, "/Balance_Training_Bicycle.png");
        repository.save(productBalanceTrainingBicycle);
        Product product43PieceDinnerSet = new Product(2, "43 Piece dinner Set", 12.95, "/43_Piece_dinner_Set.png");
        repository.save(product43PieceDinnerSet);
    }

    @Test
    public void getAllProductShouldBe2ProductsWithTrainingBicycleAndDinnerSet() {
        ProductResponse productBalanceTrainingBicycle = new ProductResponse(1, "Balance Training Bicycle", 119.95, "/Balance_Training_Bicycle.png");
        ProductResponse product43PieceDinnerSet = new ProductResponse(2, "43 Piece dinner Set", 12.95, "/43_Piece_dinner_Set.png");

        ProductListResponse actualResult = testRestTemplate.getForObject("/api/v1/product", ProductListResponse.class);

        assertEquals(2, actualResult.getTotal());
        assertEquals(productBalanceTrainingBicycle, actualResult.getProducts().get(0));
        assertEquals(product43PieceDinnerSet, actualResult.getProducts().get(1));
    }
}
