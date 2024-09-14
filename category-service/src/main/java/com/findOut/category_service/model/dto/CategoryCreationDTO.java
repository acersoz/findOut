package com.findOut.category_service.model.dto;

import lombok.Data;

@Data
public class CategoryCreationDTO {
    private Long id;
    private String name;
    private String description;
    private Long parentId;  // Only used when creating a subcategory
}
