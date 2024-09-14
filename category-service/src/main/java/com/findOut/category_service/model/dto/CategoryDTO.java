package com.findOut.category_service.model.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
    private Set<CategoryDTO> subcategories;  // Subcategories for building the tree structure
}
