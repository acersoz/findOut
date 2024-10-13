package com.findOut.category_service.service;

import com.findOut.category_service.model.dto.CategoryCreationDTO;
import com.findOut.category_service.model.dto.CategoryDTO;
import com.findOut.category_service.model.entity.CategoryEntity;
import com.findOut.category_service.model.enums.GetCategoriesType;
import com.findOut.category_service.service.mapper.CategoryMapper;
import com.findOut.category_service.service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryDTO createCategory(CategoryCreationDTO categoryCreationDTO) {
        CategoryEntity categoryEntity = categoryMapper.toCategoryEntity(categoryCreationDTO);

        if (categoryCreationDTO.getParentId() != null) {
            CategoryEntity parent = categoryRepository.findById(categoryCreationDTO.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent category not found"));
            parent.getSubcategories().add(categoryEntity); // Add the new category to parent's subcategories
            categoryRepository.save(parent); // Update parent with new subcategory
        } else {
            categoryRepository.save(categoryEntity); // Save as top-level category
        }

        return categoryMapper.toCategoryDTO(categoryEntity); // Return the new category DTO
    }

    @Override
    public Set<CategoryDTO> getCategories(String type) {
        GetCategoriesType getCategoriesType = GetCategoriesType.fromString(type);  // Convert string to enum here
        List<CategoryEntity> categoryEntities;

        // Select the correct query based on the type
        if (getCategoriesType == GetCategoriesType.ALL) {
            categoryEntities = categoryRepository.findAll();  // Get all categories
        } else if (getCategoriesType == GetCategoriesType.LEAF) {
            categoryEntities = categoryRepository.findLeafCategories();  // Get only leaf categories
        } else {
            throw new UnsupportedOperationException("Unsupported category type: " + getCategoriesType);
        }

        // Convert list to set and map to DTOs
        Set<CategoryEntity> categoryEntitySet = new HashSet<>(categoryEntities);
        return categoryMapper.toCategoryDTOs(categoryEntitySet);
    }
}
