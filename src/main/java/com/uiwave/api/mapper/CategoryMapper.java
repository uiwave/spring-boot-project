package com.uiwave.api.mapper;

import org.mapstruct.Mapper;

import com.uiwave.api.dto.request.CreateCategoryRequest;
import com.uiwave.api.dto.response.CategoryResponse;
import com.uiwave.api.model.entity.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryEntity toEntity(CreateCategoryRequest request);

    CategoryResponse toResponse(CategoryEntity entity);

}
