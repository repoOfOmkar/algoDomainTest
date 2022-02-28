package com.algodomain.service.impl;

import com.algodomain.entity.Product;
import com.algodomain.entity.ProductCategory;
import com.algodomain.entity.ProductType;
import com.algodomain.repository.ProductCategoryRepo;
import com.algodomain.repository.ProductRepo;
import com.algodomain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final ProductRepo productRepo;
    private final ProductCategoryRepo productCategoryRepo;

    @Override
    @Transactional
    public List<Product> getAllProductsByName(String name) {
        return productRepo.findByProductNameLike(name);
    }

    @Override
    @Transactional
    public List<Product> getAllProductsByCategory(ProductCategory productCategory) {
        return productRepo.findAllByProductCategory(productCategory);
    }

    @Override
    @Transactional
    public List<Product> getAllProductsByType(ProductType productType) {
        return productRepo.findAllByProductType(productType);
    }

    @Override
    @Transactional
    public List<Product> getAllProductsBtwPriceRange(Long minPrice, Long maxPrice) {
        return productRepo.findAllByPriceIsBetween(minPrice, maxPrice);
    }

    @Override
    @Transactional
    public List<ProductCategory> getAllCategories() {
        return productCategoryRepo.findAll();
    }

    @Override
    @Transactional
    public List<ProductType> getAllProductTypesForCategory(ProductCategory cat) {
        ProductCategory productCategory = productCategoryRepo.findById(cat.getCategoryName()).orElseThrow();
        return productCategory.getProductTypes();
    }

}
