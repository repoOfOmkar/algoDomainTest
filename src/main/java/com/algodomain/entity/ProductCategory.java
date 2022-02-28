package com.algodomain.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


@Entity @Data
@NoArgsConstructor
public class ProductCategory {

    @Id @GeneratedValue
    private String categoryName;

    @OneToMany(mappedBy = "productCategory")
    private List<ProductType> productTypes = new LinkedList<>();

    @OneToMany(mappedBy = "productCategory")
    private List<Product> products = new LinkedList<>();
}
