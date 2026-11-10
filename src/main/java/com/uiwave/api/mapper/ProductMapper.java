package com.uiwave.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uiwave.api.dto.request.CreateProductRequest;
import com.uiwave.api.dto.response.ProductResponse;
import com.uiwave.api.model.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    ProductEntity toEntity(CreateProductRequest request);

    ProductResponse toResponse(ProductEntity entity);

}
