package com.algodomain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data @NoArgsConstructor
public class ProductType {
    @Id
    private String productType;

    @ManyToOne
    private ProductCategory productCategory;
}
