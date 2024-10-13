package com.findOut.category_service.service.repository;

import com.findOut.category_service.model.entity.CategoryEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends Neo4jRepository<CategoryEntity, Long> {

    @Query("MATCH (c:CategoryEntity) " +
            "WHERE NOT (c)-[:"+ CategoryEntity.HAS_SUBCATEGORY_RELATIONSHIP +"]->() " +
            "RETURN c")
    List<CategoryEntity> findLeafCategories();
}
