package com.algodomain.controller;

import com.algodomain.entity.Product;
import com.algodomain.entity.ProductCategory;
import com.algodomain.entity.ProductType;
import com.algodomain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerServiceImpl;

    @GetMapping("/fetch-products/name/{name}")
    public ResponseEntity<List<Product>> fetchProductByName(@PathVariable("name") String name) {
        List<Product> products = customerServiceImpl.getAllProductsByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/fetch-products/category/{category}")
    public ResponseEntity<List<Product>> fetchProductByCategory(@PathVariable("category") String category) {
        ProductCategory cat = new ProductCategory();
        cat.setCategoryName(category);
        List<Product> products = customerServiceImpl.getAllProductsByCategory(cat);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/fetch-products/type/{category}/{type}")
    public ResponseEntity<List<Product>> fetchProductByType(@PathVariable("category") String category, @PathVariable("type") String type) {
        ProductType productType = new ProductType();
        ProductCategory cat = new ProductCategory();
        cat.setCategoryName(category);
        productType.setProductCategory(cat);
        productType.setProductType(type);
        List<Product> products = customerServiceImpl.getAllProductsByType(productType);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/fetch-products/price-range/{min}/{max}")
    public ResponseEntity<List<Product>> fetchProductInPriceRange(@PathVariable("min") Long min, @PathVariable("max") Long max) {
        List<Product> products = customerServiceImpl.getAllProductsBtwPriceRange(min, max);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/list-categories")
    public ResponseEntity<List<ProductCategory>> fetchCategories() {
        List<ProductCategory> products = customerServiceImpl.getAllCategories();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/list-product-types/{category}")
    public ResponseEntity<List<ProductType>> fetchProductTypes(@PathVariable("category") String category) {
        ProductCategory cat = new ProductCategory();
        cat.setCategoryName(category);
        List<ProductType> products = customerServiceImpl.getAllProductTypesForCategory(cat);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
