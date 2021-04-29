package co.com.clothesstore.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Product.
 */
@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3957391629228556819L;

    /** The id. */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /** The price. */
    @Column
    private Double price;

    /** The price discount. */
    @Column(name = "price_discount")
    private Double priceDiscount;

    /** The discount. */
    @Column
    private Double discount;

    /** The front picture. */
    @Column(name = "front_picture")
    private String frontPicture;

    /** The back picture. */
    @Column(name = "back_picture")
    private String backPicture;

    /** The visitor counter. */
    @Column(name = "visitor_counter")
    private Integer visitorCounter = 0;

    /** The description. */
    @Column
    private String description;

    /**
     * Instantiates a new product.
     */
    public Product() {
        super();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets the price discount.
     *
     * @return the price discount
     */
    public Double getPriceDiscount() {
        return priceDiscount;
    }

    /**
     * Sets the price discount.
     *
     * @param priceDiscount the new price discount
     */
    public void setPriceDiscount(Double priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    /**
     * Gets the discount.
     *
     * @return the discount
     */
    public Double getDiscount() {
        return discount;
    }

    /**
     * Sets the discount.
     *
     * @param discount the new discount
     */
    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    /**
     * Gets the front picture.
     *
     * @return the front picture
     */
    public String getFrontPicture() {
        return frontPicture;
    }

    /**
     * Sets the front picture.
     *
     * @param frontPicture the new front picture
     */
    public void setFrontPicture(String frontPicture) {
        this.frontPicture = frontPicture;
    }

    /**
     * Gets the back picture.
     *
     * @return the back picture
     */
    public String getBackPicture() {
        return backPicture;
    }

    /**
     * Sets the back picture.
     *
     * @param backPicture the new back picture
     */
    public void setBackPicture(String backPicture) {
        this.backPicture = backPicture;
    }

    /**
     * Gets the visitor counter.
     *
     * @return the visitor counter
     */
    public Integer getVisitorCounter() {
        return visitorCounter;
    }

    /**
     * Sets the visitor counter.
     *
     * @param visitorCounter the new visitor counter
     */
    public void setVisitorCounter(Integer visitorCounter) {
        this.visitorCounter = visitorCounter;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
