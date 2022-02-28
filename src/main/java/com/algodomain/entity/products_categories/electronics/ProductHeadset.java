package com.algodomain.entity.products_categories.electronics;

import com.algodomain.entity.ProductDetails;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data @NoArgsConstructor
public class ProductHeadset implements ProductDetails {

    @NotBlank
    private String drivers;

    @NotBlank
    private boolean hasNoiseCancellation;

    @NotBlank
    private boolean hasWarranty;

    @Positive
    private Long bluetoothVersion;
}