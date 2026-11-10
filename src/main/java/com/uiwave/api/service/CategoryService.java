package com.uiwave.api.service;

import java.util.List;

import com.uiwave.api.dto.request.CreateCategoryRequest;
import com.uiwave.api.dto.response.CategoryResponse;

public interface CategoryService {

    CategoryResponse create(CreateCategoryRequest request);

    List<CategoryResponse> getAll();
}
