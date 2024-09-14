package com.findOut.category_service.service.repository;

import com.findOut.category_service.model.entity.CategoryEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends Neo4jRepository<CategoryEntity, Long> {
    // Define custom queries if needed
}
