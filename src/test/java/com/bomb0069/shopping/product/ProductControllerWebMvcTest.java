package com.bomb0069.shopping.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {

    @MockBean
    ProductRepository productRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllProductWithEmptyDatabaseShouldBeEmptyList() throws Exception {
        List<Product> products = new ArrayList<Product>();

        given(productRepository.findAll()).willReturn(products);

        String response = this.mvc.perform(get("/api/v1/product"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        ProductListResponse actual = mapper.readValue(response, ProductListResponse.class);

        assertEquals(0, actual.getTotal());
    }

    @Test
    public void getAllProductWithOnlyOneProductShouldBeThatProduct() throws Exception {
        ProductResponse expectedProduct = new ProductResponse(1, "Balance Training Bicycle", 119.95, "/Balance_Training_Bicycle.png");

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Balance Training Bicycle", 119.95, "/Balance_Training_Bicycle.png"));

        given(productRepository.findAll()).willReturn(products);

        String response = this.mvc.perform(get("/api/v1/product"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        ProductListResponse actual = mapper.readValue(response, ProductListResponse.class);

        assertEquals(1, actual.getTotal());
        assertEquals(expectedProduct, actual.getProducts().get(0));
    }

    @Test
    public void getAllProductWithMoreThanOneProductShouldBeReturnAllOfThat() throws Exception {
        ProductResponse expectedFirstProduct = new ProductResponse(1, "Balance Training Bicycle", 119.95, "/Balance_Training_Bicycle.png");
        ProductResponse expectedSecondProduct = new ProductResponse(2, "43 Piece dinner Set", 12.95, "/43_Piece_dinner_Set.png");

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Balance Training Bicycle", 119.95, "/Balance_Training_Bicycle.png"));
        products.add(new Product(2, "43 Piece dinner Set", 12.95, "/43_Piece_dinner_Set.png"));

        given(productRepository.findAll()).willReturn(products);

        String response = this.mvc.perform(get("/api/v1/product"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        ProductListResponse actual = mapper.readValue(response, ProductListResponse.class);

        assertEquals(2, actual.getTotal());
        assertEquals(expectedFirstProduct, actual.getProducts().get(0));
        assertEquals(expectedSecondProduct, actual.getProducts().get(1));
    }

    @Test
    public void getProductId1WithOnlyOneProductShouldBeReturnProductBalanceTrainingBicycle() throws Exception {
        ProductResponse expectedFirstProduct = new ProductResponse(1, "Balance Training Bicycle", 119.95, "/Balance_Training_Bicycle.png");

        Optional<Product> productOptional = Optional.of(new Product(1, "Balance Training Bicycle", 119.95, "/Balance_Training_Bicycle.png"));

        given(productRepository.findById(1)).willReturn(productOptional);

        String response = this.mvc.perform(get("/api/v1/product/1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        ProductResponse actual = mapper.readValue(response, ProductResponse.class);

        assertEquals(expectedFirstProduct, actual);
    }

    @Test
    public void getProductId1WithEmptyDatabaseShouldBeReturnProductErrorResponse() throws Exception {

        ProductErrorResponse expectedError = new ProductErrorResponse(1);

        Optional<Product> productOptional = Optional.empty();

        given(productRepository.findById(1)).willReturn(productOptional);

        String response = this.mvc.perform(get("/api/v1/product/1"))
                .andExpect(status().isNotFound())
                .andReturn()
                .getResponse()
                .getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        ProductErrorResponse actual = mapper.readValue(response, ProductErrorResponse.class);

        assertEquals(expectedError, actual);
    }

    @Test
    public void getProductId2WithEmptyDatabaseShouldBeReturnProductErrorResponse() throws Exception {

        ProductErrorResponse expectedError = new ProductErrorResponse(2);

        Optional<Product> productOptional = Optional.empty();

        given(productRepository.findById(1)).willReturn(productOptional);

        String response = this.mvc.perform(get("/api/v1/product/2"))
                .andExpect(status().isNotFound())
                .andReturn()
                .getResponse()
                .getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        ProductErrorResponse actual = mapper.readValue(response, ProductErrorResponse.class);

        assertEquals(expectedError, actual);
    }
}
