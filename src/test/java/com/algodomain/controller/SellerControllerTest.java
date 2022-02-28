package com.algodomain.controller;

import com.algodomain.ProductHelper;
import com.algodomain.dto.ProductDto;
import static org.junit.Assert.*;

import com.algodomain.entity.Product;
import com.algodomain.entity.ProductCategory;
import com.algodomain.entity.ProductType;
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
public class SellerControllerTest {

    @Autowired
    private SellerController sellerController;

    public static List<ProductDto> productList = new ArrayList<>(4);
    static {
        productList.add(ProductHelper.getHealthProductMedicine());
        productList.add(ProductHelper.getHealthProductCream());
        productList.add(ProductHelper.getElectronicsProductHeadset());
        productList.add(ProductHelper.getElectronicsProductLaptop());
    }

    @Test
    @Transactional
    public void addNewProductTest() {
        ResponseEntity<Void> response = sellerController.addNewProduct(ProductHelper.getElectronicsProductHeadset());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Transactional
    public void addNewProductTest_B() {
        ResponseEntity<Void> response = sellerController.addNewProduct(ProductHelper.getElectronicsProductLaptop());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Transactional
    public void addManyProductsTest() {
        ResponseEntity<Void> response = sellerController.addManyProducts(productList);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Transactional
    public void getAllProductsTest() {
        ResponseEntity<Void> addResponse = sellerController.addManyProducts(productList);
        assertEquals(HttpStatus.OK, addResponse.getStatusCode());

        ResponseEntity<List<Product>> getResponse = sellerController.getAllProducts(2222L);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertNotNull(getResponse.getBody());
    }

    @Test
    @Transactional
    public void getProductTest() {
        ResponseEntity<Void> addResponse = sellerController.addNewProduct(ProductHelper.getElectronicsProductLaptop());
        assertEquals(HttpStatus.OK, addResponse.getStatusCode());

        ResponseEntity<Product> response = sellerController.getProduct(ProductHelper.getElectronicsProductLaptop().getProductId());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("electronics", response.getBody().getProductCategory().getCategoryName());
    }

    @Test
    @Transactional
    public void updateProductTest() {
        ResponseEntity<Void> addResponse = sellerController.addNewProduct(ProductHelper.getElectronicsProductLaptop());
        assertEquals(HttpStatus.OK, addResponse.getStatusCode());

        ProductDto updatedProduct = ProductHelper.getElectronicsProductLaptop();
        updatedProduct.setProductName("Lenovo 4000");
        updatedProduct.setPrice(39999L);

        ResponseEntity<Void> updateResponse = sellerController.updateProduct(updatedProduct);
        assertEquals(HttpStatus.OK, updateResponse.getStatusCode());
    }

    @Test
    @Transactional
    public void deleteProductTest() {
        ResponseEntity<Void> addResponse = sellerController.addNewProduct(ProductHelper.getElectronicsProductLaptop());
        assertEquals(HttpStatus.OK, addResponse.getStatusCode());

        ResponseEntity<Product> response = sellerController.getProduct(ProductHelper.getElectronicsProductLaptop().getProductId());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(java.util.Optional.of(1L).get(), ProductHelper.getElectronicsProductLaptop().getProductId());

        ResponseEntity<Void> deleteResponse = sellerController.deleteProduct(ProductHelper.getElectronicsProductLaptop().getProductId());
        assertEquals(HttpStatus.OK, deleteResponse.getStatusCode());
    }

    @Test
    @Transactional
    public void fetchCategoriesTest() {
        ResponseEntity<List<ProductCategory>> response = sellerController.fetchCategories();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(3, response.getBody().size());
    }

    @Test
    @Transactional
    public void fetchProductTypesTest() {
        ResponseEntity<List<ProductType>> response = sellerController.fetchProductTypes("electronics");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
    }
}
