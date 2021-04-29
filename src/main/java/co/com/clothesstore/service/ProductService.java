package co.com.clothesstore.service;

import java.util.List;

import co.com.clothesstore.models.Product;
import co.com.clothesstore.models.Status;


/**
 * The Interface ProductService.
 */
public interface ProductService {

    /**
     * Save product.
     *
     * @param Product the product
     * @return the product
     */
    Product saveProduct(Product Product);

    /**
     * Delete Product.
     *
     * @param Product the Product
     * @return the status
     */
    Status deleteProduct(String Product);

    /**
     * Gets the Product.
     *
     * @param id the id
     * @return the Product
     */
    Product getProduct(String id);
    
    /**
     * Gets the product by name.
     *
     * @param name the name
     * @return the product by name
     */
    List<Product> getProductByName(String name);

    /**
     * Gets the Products.
     *
     * @return the Products
     */
    List<Product> getProducts();
}
