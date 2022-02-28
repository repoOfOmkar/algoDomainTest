package com.algodomain.controller;

import com.algodomain.dto.ProductDto;
import com.algodomain.entity.Product;
import com.algodomain.entity.ProductCategory;
import com.algodomain.entity.ProductType;
import com.algodomain.entity.User;
import com.algodomain.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/seller")
@Validated @RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerServiceImpl;

    @PostMapping("/add-product")
    public ResponseEntity<Void> addNewProduct(@RequestBody @Valid ProductDto productDto) {
        sellerServiceImpl.addSingleProduct(mapProductDtoToProduct(productDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add-multi-products")
    public ResponseEntity<Void> addManyProducts(@RequestBody @Valid List<ProductDto> productDtos) {
        List<Product> products = new LinkedList<>();
        for (ProductDto productDto : productDtos) {
            products.add(mapProductDtoToProduct(productDto));
        }
        sellerServiceImpl.addMultipleProducts(products);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-all-products/{product-id}")
    public ResponseEntity<Product> getProduct(@PathVariable("product-id") Long productId) {
        Product product = sellerServiceImpl.getProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/get-all-products/{user-id}")
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable("user-id") Long userId) {
        List<Product> products = sellerServiceImpl.getAllProducts(userId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @PutMapping("/update-product")
    public ResponseEntity<Void> updateProduct(@RequestBody @Valid ProductDto productDto) {
        sellerServiceImpl.updateProduct(mapProductDtoToProduct(productDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete-product/{product-id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("product-id") Long productId) {
        sellerServiceImpl.removeProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list-categories")
    public ResponseEntity<List<ProductCategory>> fetchCategories() {
        List<ProductCategory> products = sellerServiceImpl.getAllCategories();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/list-product-types/{category}")
    public ResponseEntity<List<ProductType>> fetchProductTypes(@PathVariable("category") String category) {
        ProductCategory cat = new ProductCategory();
        cat.setCategoryName(category);
        List<ProductType> products = sellerServiceImpl.getAllProductTypesForCategory(cat);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    private Product mapProductDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        User user = new User();
        user.setId(productDto.getUserId());
        product.setUserId(user);
        product.setPrice(productDto.getPrice());
        product.setProductDetails(productDto.getProductDetails());
        product.setProductName(productDto.getProductName());
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName(productDto.getProductCategory());
        ProductType productType = new ProductType();
        productType.setProductType(productDto.getProductType());
        product.setProductType(productType);
        product.setProductCategory(productCategory);
        if(productDto.getProductId() != null && productDto.getProductId() > 0L) {
            product.setId(productDto.getProductId());
        }
        return product;
    }
}
