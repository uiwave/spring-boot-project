package com.uiwave.api.service.impl;

import org.springframework.stereotype.Service;

import com.uiwave.api.repository.CategoryRepository;
import com.uiwave.api.service.CategoryService;

@Service 
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

}
