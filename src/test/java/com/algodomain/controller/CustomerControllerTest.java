package com.algodomain.controller;

import static org.junit.Assert.*;

import com.algodomain.ProductHelper;
import com.algodomain.dto.ProductDto;
import com.algodomain.entity.Product;
import com.algodomain.entity.ProductCategory;
import com.algodomain.entity.ProductType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    @Autowired
    private CustomerController customerController;

    @Autowired
    private SellerController sellerController;

    @Before
    @Transactional
    public void persistQueries() {
        List<ProductDto> productList = new ArrayList<>();
        productList.add(ProductHelper.getHealthProductMedicine());
        productList.add(ProductHelper.getHealthProductCream());
        productList.add(ProductHelper.getElectronicsProductHeadset());
        productList.add(ProductHelper.getElectronicsProductLaptop());
        sellerController.addManyProducts(productList);
    }

    @Test
    @Transactional
    public void fetchProductByNameTest() {
        ResponseEntity<List<Product>> response = customerController.fetchProductByName("Dell");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(java.util.Optional.of(2222L).get(), response.getBody().get(0).getUserId().getId());
    }

    @Test
    @Transactional
    public void fetchProductByCategoryTest() {
        ResponseEntity<List<Product>> response = customerController.fetchProductByCategory("health");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("health", response.getBody().get(0).getProductCategory().getCategoryName());
    }

    @Test
    @Transactional
    public void fetchProductByTypeTest() {
        ResponseEntity<List<Product>> response = customerController.fetchProductByType("electronics", "laptop");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    @Transactional
    public void fetchProductInPriceRangeTest() {
        ResponseEntity<List<Product>> response = customerController.fetchProductInPriceRange(990L, 10000L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    @Transactional
    public void fetchCategoriesTest() {
        ResponseEntity<List<ProductCategory>> response = customerController.fetchCategories();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(3, response.getBody().size());
    }

    @Test
    @Transactional
    public void fetchProductTypesTest() {
        ResponseEntity<List<ProductType>> response = customerController.fetchProductTypes("electronics");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
    }

}
