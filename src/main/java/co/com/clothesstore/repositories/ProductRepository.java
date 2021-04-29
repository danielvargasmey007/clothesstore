package co.com.clothesstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.clothesstore.models.Product;

/**
 * The Interface ProductRepository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

    /**
     * Find by name.
     *
     * @param name the name
     * @return the product
     */
    Product findByName(String name);

    /**
     * Find by name contaning.
     *
     * @param name the name
     * @return the list
     */
    List<Product> findByNameContainingIgnoreCase(String name);

    /**
     * Find all by order by visitor counter desc.
     *
     * @return the list
     */
    List<Product> findAllByOrderByVisitorCounterDesc(); 

}
