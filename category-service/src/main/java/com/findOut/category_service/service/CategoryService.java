package com.findOut.category_service.service;

import com.findOut.category_service.model.dto.CategoryCreationDTO;
import com.findOut.category_service.model.dto.CategoryDTO;

import java.util.Set;

public interface CategoryService {
    CategoryDTO createCategory(CategoryCreationDTO categoryCreationDTO);
    Set<CategoryDTO> getCategories(String type);
}
