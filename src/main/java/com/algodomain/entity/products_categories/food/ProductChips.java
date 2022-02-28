package com.algodomain.entity.products_categories.food;

import com.algodomain.entity.ProductDetails;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
public class ProductChips implements ProductDetails {
    @NotBlank
    private String flavour;

    @NotBlank
    private boolean containsOil;

    @NotBlank
    private String expiryDate;

    @Positive
    private Long quantity;
}
