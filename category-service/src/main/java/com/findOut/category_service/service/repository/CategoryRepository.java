package com.findOut.category_service.service.repository;

import com.findOut.category_service.model.entity.CategoryEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends Neo4jRepository<CategoryEntity, Long> {
    @Query("MATCH (parent:CategoryEntity) " +
            "WHERE NOT (parent)-[:SUBCATEGORY_OF]->() " +
            "OPTIONAL MATCH (parent)-[:HAS_SUBCATEGORY*]->(sub:CategoryEntity) " +
            "WITH parent, collect(DISTINCT sub) AS subcategories " +
            "RETURN parent {.*, subcategories: subcategories }")
    List<CategoryEntity> getCategoryTree();
}
