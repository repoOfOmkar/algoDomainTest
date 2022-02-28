package com.algodomain.service;

import com.algodomain.entity.Product;
import com.algodomain.entity.ProductCategory;
import com.algodomain.entity.ProductType;

import java.util.List;

public interface SellerService {
    void addSingleProduct(Product product);

    void addMultipleProducts(List<Product> products);

    List<Product> getAllProducts(Long id);

    Product getProduct(Long productId);

    void updateProduct(Product product);

    void removeProduct(Long productId);

    List<ProductCategory> getAllCategories();

    List<ProductType> getAllProductTypesForCategory(ProductCategory cat);
}
