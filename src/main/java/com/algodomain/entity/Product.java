package com.algodomain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id @GeneratedValue
    private long id;

    @ManyToOne
    private User userId;

    private String productName;

    @ManyToOne
    private ProductCategory productCategory;

    private String productDetails;

    @ManyToOne
    private ProductType productType;

    private Long price;

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails.toString();
    }
}
