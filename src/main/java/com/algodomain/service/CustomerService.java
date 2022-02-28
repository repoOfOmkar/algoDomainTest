package com.algodomain.service;

import com.algodomain.entity.Product;
import com.algodomain.entity.ProductCategory;
import com.algodomain.entity.ProductType;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerService {
    List<Product> getAllProductsByName(String name);

    List<Product> getAllProductsByCategory(ProductCategory productCategory);

    List<Product> getAllProductsByType(ProductType productType);

    List<Product> getAllProductsBtwPriceRange(Long minPrice, Long maxPrice);

    @Transactional
    List<ProductCategory> getAllCategories();

    @Transactional
    List<ProductType> getAllProductTypesForCategory(ProductCategory cat);
}
