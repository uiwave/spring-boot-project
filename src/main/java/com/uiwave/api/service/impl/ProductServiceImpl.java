package com.uiwave.api.service.impl;

import org.springframework.stereotype.Service;

import com.uiwave.api.dto.request.CreateProductRequest;
import com.uiwave.api.dto.response.ProductResponse;
import com.uiwave.api.mapper.ProductMapper;
import com.uiwave.api.model.entity.ProductEntity;
import com.uiwave.api.repository.ProductRepository;
import com.uiwave.api.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse create(CreateProductRequest request) {

        if (productRepository.existsByName(request.name().trim())) {
            throw new IllegalArgumentException("Product already exists");
        }

        ProductEntity product = productMapper.toEntity(request);

        product.setName(request.name().trim());

        ProductEntity saved = productRepository.save(product);

        return productMapper.toResponse(saved);
    }
}
