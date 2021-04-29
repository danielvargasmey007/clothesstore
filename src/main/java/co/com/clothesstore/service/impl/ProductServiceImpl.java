package co.com.clothesstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.clothesstore.models.Product;
import co.com.clothesstore.models.Status;
import co.com.clothesstore.repositories.ProductRepository;
import co.com.clothesstore.service.ProductService;

/**
 * The Class ProductServiceImpl.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    /** The product repository. */
    private ProductRepository productRepository;
    
    /**
     * Instantiates a new product service impl.
     *
     * @param productRepository the product repository
     */
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    /**
     * Save product.
     *
     * @param Product the product
     * @return the product
     */
    @Override
    public Product saveProduct(Product Product) {
        return this.productRepository.save(Product);
    }

    /**
     * Delete product.
     *
     * @param product the product
     * @return the status
     */
    @Override
    public Status deleteProduct(String product) {
        Status response = new Status();
        try {
            this.productRepository.deleteById(product);
            response.setMessage("request executed successfully.");
            response.setResponse("SUCCES");
        } catch (Exception e) {
            response.setMessage("request executed with error.");
            response.setResponse("ERROR");
        }
        return response;
    }

    /**
     * Gets the product.
     *
     * @param id the id
     * @return the product
     */
    @Override
    public Product getProduct(String id) {
        Product prodcut = this.productRepository.findById(id).orElse(null);
        if(prodcut != null) {
            Integer counter = prodcut.getVisitorCounter();
            
            if(counter != null) {
                counter += 1;
            }else {
                counter = 1;
            }
            prodcut.setVisitorCounter(counter);
            this.productRepository.save(prodcut);
        }
        return prodcut;
    }

    /**
     * Gets the products.
     *
     * @return the products
     */
    @Override
    public List<Product> getProducts() {
        return this.productRepository.findAllByOrderByVisitorCounterDesc();
    }

    /**
     * Gets the product by name.
     *
     * @param name the name
     * @return the product by name
     */
    @Override
    public List<Product> getProductByName(String name) {
        return this.productRepository.findByNameContainingIgnoreCase(name);
    }

}
