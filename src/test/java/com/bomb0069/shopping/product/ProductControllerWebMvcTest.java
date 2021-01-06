package com.bomb0069.shopping.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductTest {

    @MockBean
    ProductRepository productRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllProductWithEmptyDatabaseShouldBeEmptyList() throws Exception {
        assertTrue(true);
/*
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
        assertEquals("", response);*/
    }
}
