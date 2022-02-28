package com.algodomain.repository;

import com.algodomain.entity.Product;
import com.algodomain.entity.ProductCategory;
import com.algodomain.entity.ProductType;
import com.algodomain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findAllProductsByUserId(User userId);

    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:name%")
    List<Product> findByProductNameLike(@Param("name") String name);

    List<Product> findAllByProductCategory(ProductCategory productCategory);

    List<Product> findAllByProductType(ProductType productType);

    @Query(value = "SELECT * FROM product WHERE price > :minPrice AND price < :maxPrice", nativeQuery = true)
    List<Product> findAllByPriceIsBetween(Long minPrice, Long maxPrice);
}
