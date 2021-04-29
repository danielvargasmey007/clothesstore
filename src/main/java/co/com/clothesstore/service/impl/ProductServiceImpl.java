package co.com.clothesstore.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.clothesstore.models.Product;
import co.com.clothesstore.models.Status;
import co.com.clothesstore.service.ProductService;

/**
 * The Class ProductServiceImpl.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    /**
     * Save product.
     *
     * @param Product the product
     * @return the product
     */
    @Override
    public Product saveProduct(Product Product) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Delete product.
     *
     * @param Product the product
     * @return the status
     */
    @Override
    public Status deleteProduct(String Product) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Gets the product.
     *
     * @param id the id
     * @return the product
     */
    @Override
    public Product getProduct(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Gets the products.
     *
     * @return the products
     */
    @Override
    public List<Product> getProducts() {
        // TODO Auto-generated method stub
        return null;
    }

}
