package co.com.clothesstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.clothesstore.models.Product;
import co.com.clothesstore.models.Status;
import co.com.clothesstore.service.ProductService;


/**
 * The Class ProductController.
 */
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {
    
    /** The product service. */
    private ProductService productService;

    /**
     * Instantiates a new product controller.
     *
     * @param productService the product service
     */
    @Autowired
    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }
    
    
    /**
     * Save Product.
     *
     * @param product the product
     * @return the Product
     */
    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return this.productService.saveProduct(product);
    }

    /**
     * Delete Product.
     *
     * @param id the id
     * @return the status
     */
    @DeleteMapping("/{id}")
    public Status deleteProduct(@PathVariable String id) {
        return this.productService.deleteProduct(id);
    }

    /**
     * Gets the Product.
     *
     * @param id the id
     * @return the Product
     */
    @GetMapping("all/{id}")
    public Product getProduct(@PathVariable String id) {
        return this.productService.getProduct(id);
    }
    
    /**
     * Gets the product by name.
     *
     * @param name the name
     * @return the product by name
     */
    @GetMapping("specific/{name}")
    public List<Product> getProductByName(@PathVariable String name) {
        return this.productService.getProductByName(name);
    }

    /**
     * Gets the Products.
     *
     * @return the Products
     */
    @GetMapping
    public List<Product> getProducts() {
        return this.productService.getProducts();
    }

}
