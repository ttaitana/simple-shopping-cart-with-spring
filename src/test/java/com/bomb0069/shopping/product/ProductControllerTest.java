package com.bomb0069.shopping.product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired ProductRepository repository;

    Product productBalanceTrainingBicycle = new Product(1, "Balance Training Bicycle", 119.95, "/Balance_Training_Bicycle.png");
    Product product43PieceDinnerSet = new Product(2, "43 Piece dinner Set", 12.95, "/43_Piece_dinner_Set.png");
    Product product3 = new Product(3, "43 Piece dinner Set", 12.95, "/43_Piece_dinner_Set.png");

    @AfterEach
    public void clearData () {
        repository.deleteAll();
    }

    @Test
    public void getAllProductWithEmptyShouldBe0AtTotal() {

        ProductListResponse actualResult = testRestTemplate.getForObject("/api/v1/product", ProductListResponse.class);

        assertEquals(0, actualResult.getTotal());
    }

    @Test
    public void getAllProductShouldBe2ProductsWithTrainingBicycleAndDinnerSet() {
        repository.save(productBalanceTrainingBicycle);
        repository.save(product43PieceDinnerSet);

        ProductResponse productBalanceTrainingBicycle = new ProductResponse(1, "Balance Training Bicycle", 119.95, "/Balance_Training_Bicycle.png");
        ProductResponse product43PieceDinnerSet = new ProductResponse(2, "43 Piece dinner Set", 12.95, "/43_Piece_dinner_Set.png");

        ProductListResponse actualResult = testRestTemplate.getForObject("/api/v1/product", ProductListResponse.class);

        assertEquals(2, actualResult.getTotal());
        assertEquals(productBalanceTrainingBicycle, actualResult.getProducts().get(0));
        assertEquals(product43PieceDinnerSet, actualResult.getProducts().get(1));
    }


    @Test
    public void getAllProductWith3ProductsShouldBeReturnAllOfThat() {
        repository.save(productBalanceTrainingBicycle);
        repository.save(product43PieceDinnerSet);
        repository.save(product3);

        ProductResponse expectedProductBalanceTrainingBicycle = new ProductResponse(1, "Balance Training Bicycle", 119.95, "/Balance_Training_Bicycle.png");
        ProductResponse expectedProduct43PieceDinnerSet = new ProductResponse(2, "43 Piece dinner Set", 12.95, "/43_Piece_dinner_Set.png");
        ProductResponse ExpectedProduct3 = new ProductResponse(3, "43 Piece dinner Set", 12.95, "/43_Piece_dinner_Set.png");

        ProductListResponse actualResult = testRestTemplate.getForObject("/api/v1/product", ProductListResponse.class);

        assertEquals(3, actualResult.getTotal());
        assertEquals(expectedProductBalanceTrainingBicycle, actualResult.getProducts().get(0));
        assertEquals(expectedProduct43PieceDinnerSet, actualResult.getProducts().get(1));
        assertEquals(ExpectedProduct3, actualResult.getProducts().get(2));
    }
}
