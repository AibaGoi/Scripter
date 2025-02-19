package com.example.Scripter.domain.entity.story;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Builder
@Document(collection = "Stories")
public class Story {
    @Id
    private final String id;

    @Field("title")
    private String title;

    @Field("description")
    private String description;

    @Field("userId")
    private final String userId;

    @Field("scenes")
    private List<String> scenes;

    @Field("characters")
    private List<String> characters;
}
