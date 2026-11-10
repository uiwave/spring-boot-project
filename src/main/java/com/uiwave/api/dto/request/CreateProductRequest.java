package com.uiwave.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateProductRequest(
        @NotBlank(message = "Product name is required") @Size(min = 2, max = 100, message = "Product name must contain between 2 and 100 characters") String name) {

}
