package com.algodomain.entity.products_categories.health;

import com.algodomain.entity.ProductDetails;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
public class ProductMedicine implements ProductDetails {
    @NotBlank
    private String companyName;

    @NotBlank
    private String expiryDate;

    @Positive
    private int totalTablets;
}
