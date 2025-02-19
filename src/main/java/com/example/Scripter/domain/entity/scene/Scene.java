package com.example.Scripter.domain.entity.scene;

import com.example.Scripter.domain.entity.scene.scene_block.BaseSceneBlock;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Scenes")
@Builder
public class Scene {
    @Id
    private final String id;
    private String title;
    private String description;
    private final String storyId;
    private List<String> characters;
    private List<BaseSceneBlock> sceneBlocks;
}
