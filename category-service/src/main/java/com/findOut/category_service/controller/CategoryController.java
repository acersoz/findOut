package com.findOut.category_service.controller;

import com.findOut.category_service.model.dto.CategoryCreationDTO;
import com.findOut.category_service.model.dto.CategoryDTO;
import com.findOut.category_service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // API to create a new category or subcategory
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryCreationDTO categoryCreationDTO) {
        CategoryDTO createdCategory = categoryService.createCategory(categoryCreationDTO);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Set<CategoryDTO>> getCategories(@RequestParam(required = false, defaultValue = "all") String type) {
        Set<CategoryDTO> categories = categoryService.getCategories(type);
        return ResponseEntity.ok(categories);
    }
}
