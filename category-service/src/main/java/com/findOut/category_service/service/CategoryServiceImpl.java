package com.findOut.category_service.service;

import com.findOut.category_service.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    public List<Category> getAllCategories() {
        Category category = new Category();
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        return categoryList;
    }
}
