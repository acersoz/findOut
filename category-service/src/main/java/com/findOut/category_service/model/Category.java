package com.findOut.category_service.model;

import lombok.Data;

import java.util.List;

@Data
public class Category {

    private Long id;
    private String name;
    private String description;
    private List<Category> subcategories;

}
