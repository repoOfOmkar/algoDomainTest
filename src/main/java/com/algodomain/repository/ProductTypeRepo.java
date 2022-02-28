package com.algodomain.repository;

import com.algodomain.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepo extends JpaRepository<ProductType, String> {
}
