package co.com.clothesstore.service.impl;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.clothesstore.models.Product;
import co.com.clothesstore.repositories.ProductRepository;
import co.com.clothesstore.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class ProductServiceImplTest {
    
    
    private ProductService productService;
    
    @MockBean
    private ProductRepository productRepository;
    
    @Before
    public void init() {
        productService = new ProductServiceImpl(productRepository);
    }


    @Test
    public void testSaveProduct() {
        Mockito.when(productRepository.save(Mockito.any(Product.class)))
        .thenReturn(getProductMock());
        
        Assert.assertNotNull(this.productService.saveProduct(getProductMock()));
    }

    @Test
    public void testDeleteProduct() {
        Assert.assertNotNull(this.productService.deleteProduct("1"));
    }

    @Test
    public void testGetProduct() {
        Mockito.when(productRepository.findById(Mockito.anyString()))
        .thenReturn(Optional.of(getProductMock()));
        
        Assert.assertNotNull(this.productService.getProduct("33"));
    }
    
    @Test
    public void testGetProductCase2() {
        Mockito.when(productRepository.findById(Mockito.anyString()))
        .thenReturn(Optional.of(getProductMock2()));
        
        Assert.assertNotNull(this.productService.getProduct("33"));
    }


    @Test
    public void testGetProducts() {
        Mockito.when(productRepository.findAll())
        .thenReturn(Arrays.asList(getProductMock()));
        
        Assert.assertNotNull(this.productService.getProducts());
    }

    @Test
    public void testGetProductByName() {
        Mockito.when(productRepository.findByNameContainingIgnoreCase(Mockito.anyString()))
        .thenReturn(Arrays.asList(getProductMock()));
        
        Assert.assertNotNull(this.productService.getProductByName("Blusa"));
    }
    
    private Product getProductMock() {
        Product p = new Product();
        p.setId("1");

        return p;
    }
    
    private Product getProductMock2() {
        Product p = new Product();
        p.setId("1");
        p.setVisitorCounter(1);

        return p;
    }

}
