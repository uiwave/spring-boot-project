package com.uiwave.api.service.impl;

import org.springframework.stereotype.Service;

import com.uiwave.api.dto.request.CreateCategoryRequest;
import com.uiwave.api.dto.response.CategoryResponse;
import com.uiwave.api.mapper.CategoryMapper;
import com.uiwave.api.model.entity.CategoryEntity;
import com.uiwave.api.repository.CategoryRepository;
import com.uiwave.api.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryResponse create(CreateCategoryRequest request) {

        if (categoryRepository.existsByName(request.name().trim())) {
            throw new IllegalArgumentException("Category already exists");
        }

        CategoryEntity category = categoryMapper.toEntity(request);

        category.setName(request.name().trim());

        CategoryEntity saved = categoryRepository.save(category);

        return categoryMapper.toResponse(saved);
    }

}
