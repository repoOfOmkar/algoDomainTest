package com.algodomain;

import com.algodomain.dto.ProductDto;
import com.algodomain.entity.products_categories.electronics.ProductHeadset;
import com.algodomain.entity.products_categories.electronics.ProductLaptop;
import com.algodomain.entity.products_categories.food.ProductCake;
import com.algodomain.entity.products_categories.food.ProductChips;
import com.algodomain.entity.products_categories.health.ProductCream;
import com.algodomain.entity.products_categories.health.ProductMedicine;

public class ProductHelper {
    public static ProductDto getElectronicsProductLaptop() {
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Dell Latitude");
        productDto.setProductType("laptop");
        productDto.setProductCategory("electronics");
        productDto.setPrice(1000L);
        productDto.setUserId(2222L);
        ProductLaptop productDetails = new ProductLaptop();
        productDetails.setCpu("110 Mhz");
        productDetails.setGpu("RTX 4000");
        productDetails.setRam("16 GB");
        productDetails.setScreenSize("1080x1920");
        productDto.setProductDetails(productDetails);
        productDto.setProductId(1L);
        return productDto;
    }

    public static ProductDto getElectronicsProductHeadset() {
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Boat Rokerz");
        productDto.setProductType("headset");
        productDto.setProductCategory("electronics");
        productDto.setPrice(4000L);
        productDto.setUserId(3333L);
        ProductHeadset productDetails = new ProductHeadset();
        productDetails.setDrivers("110 Mhz");
        productDetails.setBluetoothVersion(5L);
        productDetails.setHasNoiseCancellation(false);
        productDetails.setHasWarranty(true);
        productDto.setProductDetails(productDetails);
        productDto.setProductId(20L);
        return productDto;
    }

    public static ProductDto getHealthProductMedicine() {
        ProductDto productDto = new ProductDto();
        productDto.setProductName("MedicineX");
        productDto.setProductType("medicine");
        productDto.setProductCategory("health");
        productDto.setPrice(4000L);
        productDto.setUserId(2222L);
        ProductMedicine productDetails = new ProductMedicine();
        productDetails.setCompanyName("emcure");
        productDetails.setExpiryDate("20-02-2050");
        productDetails.setTotalTablets(10);
        productDto.setProductDetails(productDetails);
        productDto.setProductId(36L);
        return productDto;
    }

    public static ProductDto getHealthProductCream() {
        ProductDto productDto = new ProductDto();
        productDto.setProductName("CreamX");
        productDto.setProductType("cream");
        productDto.setProductCategory("health");
        productDto.setPrice(900L);
        productDto.setUserId(3333L);
        ProductCream productDetails = new ProductCream();
        productDetails.setCompanyName("emcure");
        productDetails.setExpiryDate("20-03-2050");
        productDetails.setQuantityInMl(15);
        productDto.setProductDetails(productDetails);
        productDto.setProductId(49L);
        return productDto;
    }

    public static ProductDto getFoodProductChips() {
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Lays");
        productDto.setProductType("chips");
        productDto.setProductCategory("food");
        productDto.setPrice(90L);
        productDto.setUserId(3333L);
        ProductChips productDetails = new ProductChips();
        productDetails.setContainsOil(false);
        productDetails.setExpiryDate("20-03-2050");
        productDetails.setFlavour("tangy");
        productDetails.setQuantity(10L);
        productDto.setProductDetails(productDetails);
        productDto.setProductId(89L);
        return productDto;
    }

    public static ProductDto getFoodProductCake() {
        ProductDto productDto = new ProductDto();
        productDto.setProductName("BakersCake");
        productDto.setProductType("cake");
        productDto.setProductCategory("food");
        productDto.setPrice(1100L);
        productDto.setUserId(2222L);
        ProductCake productDetails = new ProductCake();
        productDetails.setFlavour("chocolate");
        productDetails.setExpiryDate("20-03-2050");
        productDetails.setNonVeg(false);
        productDetails.setQuantityInKg(1L);
        productDto.setProductDetails(productDetails);
        productDto.setProductId(99L);
        return productDto;
    }
}
