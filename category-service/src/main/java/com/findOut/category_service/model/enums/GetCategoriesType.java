package com.findOut.category_service.model.enums;

public enum GetCategoriesType {
    ALL,
    LEAF;

    public static GetCategoriesType fromString(String type) {
        try {
            return GetCategoriesType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid category type: " + type);
        }
    }
}
