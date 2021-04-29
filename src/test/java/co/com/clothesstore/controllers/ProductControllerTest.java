package co.com.clothesstore.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import co.com.clothesstore.models.Product;
import co.com.clothesstore.models.Status;
import co.com.clothesstore.service.ProductService;

/**
 * The Class ProductControllerTest.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class ProductControllerTest {

    /** The mock mvc. */
    @Autowired
    protected MockMvc mockMvc;

    /** The product service. */
    @MockBean
    protected ProductService productService;

    /** The object mapper. */
    private ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    /**
     * Test save product.
     *
     * @throws JsonProcessingException the json processing exception
     * @throws Exception               the exception
     */
    @Test
    public void testSaveProduct() throws JsonProcessingException, Exception {
        Mockito.when(productService.saveProduct(Mockito.any(Product.class)))
                .thenReturn(getProductMock());

        mockMvc.perform(post("/product").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(getProductMock())))
                .andExpect(status().isOk());
    }

    /**
     * Test delete product.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDeleteProduct() throws Exception {
        Mockito.when(productService.deleteProduct(Mockito.anyString())).thenReturn(new Status());

        mockMvc.perform(delete("/product/1")).andExpect(status().isOk());
    }

    /**
     * Test get product.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetProduct() throws Exception {
        Mockito.when(productService.getProduct(Mockito.anyString())).thenReturn(getProductMock());

        mockMvc.perform(get("/product/all/1")).andExpect(status().isOk());
    }

    /**
     * Test get product by name.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetProductByName() throws Exception {
        Mockito.when(productService.getProductByName(Mockito.anyString()))
                .thenReturn(Arrays.asList(getProductMock()));

        mockMvc.perform(get("/product/specific/1")).andExpect(status().isOk());
    }

    /**
     * Test get products.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetProducts() throws Exception {
        Mockito.when(productService.getProducts()).thenReturn(Arrays.asList(getProductMock()));

        mockMvc.perform(get("/product")).andExpect(status().isOk());
    }

    /**
     * Gets the product mock.
     *
     * @return the product mock
     */
    private Product getProductMock() {
        Product p = new Product();
        p.setId("1");

        return p;
    }
}
