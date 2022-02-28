package com.algodomain.dto;

import com.algodomain.entity.ProductDetails;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data @NoArgsConstructor
public class ProductDto {
    @Positive
    private Long userId;

    @NotBlank
    private String productName;

    @NotBlank
    private String productCategory;

    @NotBlank
    private String productType;

    @PositiveOrZero
    private Long price;

    @NotNull
    private ProductDetails productDetails;

    private Long productId;
}
