package com.algodomain.service.impl;

import com.algodomain.entity.*;
import com.algodomain.repository.ProductCategoryRepo;
import com.algodomain.repository.ProductRepo;
import com.algodomain.repository.ProductTypeRepo;
import com.algodomain.repository.UserRepo;
import com.algodomain.service.SellerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final UserRepo userRepo;
    private final ProductRepo productRepo;
    private final ProductCategoryRepo productCategoryRepo;
    private final ProductTypeRepo productTypeRepo;

    @Override
    @Transactional
    public void addSingleProduct(Product product) {
        User user = userRepo.findById(product.getUserId().getId()).orElseThrow();
        if(user.isAdmin() || user.isSeller()) {
            ProductCategory productCategory = productCategoryRepo.findById(product.getProductCategory().getCategoryName())
                    .orElseThrow();
            ProductType productType = productTypeRepo.findById(product.getProductType().getProductType())
                    .orElseThrow();
            product.setProductCategory(productCategory);
            product.setProductType(productType);
            productRepo.saveAndFlush(product);
        } else throw new RuntimeException();
    }

    @Override
    @Transactional
    public void addMultipleProducts(List<Product> products) {
        for (Product product: products) {
            addSingleProduct(product);
        }
    }

    @Override
    @Transactional
    public List<Product> getAllProducts(Long uid) {
        User user = userRepo.findById(uid).orElseThrow();
        return productRepo.findAllProductsByUserId(user);
    }

    @Override
    @Transactional
    public Product getProduct(Long productId) {
        return productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Invalid" + productId));
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        User user = userRepo.findById(product.getUserId().getId()).orElseThrow();
        Product oldProduct = getProduct(product.getId());
        if(user.isAdmin() || (user.isSeller() && Objects.equals(oldProduct.getUserId().getId(), user.getId()))) {
            productRepo.saveAndFlush(product);
        } else throw new RuntimeException();
    }


    @Override
    @Transactional
    public void removeProduct(Long productId) {
        Product product = productRepo.findById(productId).orElseThrow();
        User user = userRepo.findById(product.getUserId().getId()).orElseThrow();
        if(user.isAdmin() || (user.isSeller() && Objects.equals(product.getUserId().getId(), user.getId()))) {
            productRepo.delete(product);
        } else throw new RuntimeException();
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
