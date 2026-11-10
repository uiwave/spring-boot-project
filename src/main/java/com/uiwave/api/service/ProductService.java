package com.uiwave.api.service;

import com.uiwave.api.dto.request.CreateProductRequest;
import com.uiwave.api.dto.response.ProductResponse;

public interface ProductService {

    ProductResponse create(CreateProductRequest request);

}
