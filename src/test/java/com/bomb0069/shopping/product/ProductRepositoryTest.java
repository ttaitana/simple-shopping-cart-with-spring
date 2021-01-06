package com.bomb0069.shopping.product;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void emptyProductShouldBeIsNotPresent() {

        assertEquals(0, sizeOf(productRepository.findAll()));

    }

    @Test
    public void oneOfProductShouldBeReturnThat() {

        productRepository.save(new Product(1, "Balance Training Bicycle", 119.95, "/Balance_Training_Bicycle.png"));

        assertEquals(1, sizeOf(productRepository.findAll()));

    }

    @Test
    public void twoOfProductShouldBeReturnAll() {

        productRepository.save(new Product(1, "Balance Training Bicycle", 119.95, "/Balance_Training_Bicycle.png"));
        productRepository.save(new Product(2, "43 Piece dinner Set", 12.95, "/43_Piece_dinner_Set.png"));

        assertEquals(2, sizeOf(productRepository.findAll()));

    }

    private int sizeOf(Iterable<Product> products) {
        int counter = 0;
        if (products instanceof Collection) {
            counter = ((Collection<?>) products).size();
        } else {
            for (Object i : products) {
                counter++;
            }
        }
        return counter;
    }
}
