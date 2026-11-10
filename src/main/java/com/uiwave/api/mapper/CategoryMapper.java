package com.uiwave.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uiwave.api.dto.request.CreateCategoryRequest;
import com.uiwave.api.dto.response.CategoryResponse;
import com.uiwave.api.model.entity.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    CategoryEntity toEntity(CreateCategoryRequest request);

    CategoryResponse toResponse(CategoryEntity entity);

    List<CategoryResponse> toResponseList(List<CategoryEntity> entities);

}
