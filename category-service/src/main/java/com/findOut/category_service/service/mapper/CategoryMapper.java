package com.findOut.category_service.service.mapper;

import com.findOut.category_service.model.dto.CategoryCreationDTO;
import com.findOut.category_service.model.dto.CategoryDTO;
import com.findOut.category_service.model.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // Map from CategoryCreationDTO to CategoryEntity
    CategoryEntity toCategoryEntity(CategoryCreationDTO categoryCreationDTO);

    // Map from CategoryEntity to CategoryDTO
    CategoryDTO toCategoryDTO(CategoryEntity categoryEntity);

    // Map a set of CategoryEntity to a set of CategoryDTO
    Set<CategoryDTO> toCategoryDTOs(Set<CategoryEntity> categoryEntities);
}