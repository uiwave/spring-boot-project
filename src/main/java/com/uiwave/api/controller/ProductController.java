package com.uiwave.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uiwave.api.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor 
public class ProductController {

    private final ProductService productService;

}
