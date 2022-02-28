package com.algodomain.entity.products_categories.electronics;

import com.algodomain.entity.ProductDetails;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data @NoArgsConstructor
public class ProductLaptop implements ProductDetails {
    @NotBlank
    private String ram;

    @NotBlank
    private String cpu;

    @NotBlank
    private String screenSize;

    @NotBlank
    private String gpu;
}
