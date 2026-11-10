package com.uiwave.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uiwave.api.model.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    boolean existsByName(String name);

}
