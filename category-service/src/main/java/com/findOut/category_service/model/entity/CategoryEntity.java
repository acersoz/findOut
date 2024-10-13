package com.findOut.category_service.model.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@Data
@Node
public class CategoryEntity {

    public static final String HAS_SUBCATEGORY_RELATIONSHIP = "HAS_SUBCATEGORY";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @Relationship(type = HAS_SUBCATEGORY_RELATIONSHIP, direction = Relationship.Direction.OUTGOING)
    private Set<CategoryEntity> subcategories;
}
