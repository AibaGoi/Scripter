package com.example.Scripter.domain.entity.character;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Characters")
@Builder
public class Character {
    @Id
    private final String id;
    private String name;
    private String description;
    private final String storyId;
}
