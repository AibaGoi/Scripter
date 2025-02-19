package com.example.Scripter.web.dto.scene;

import com.example.Scripter.domain.entity.scene.scene_block.BaseSceneBlock;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CreateSceneDto {
    @NotBlank(message = "Title must not be empty")
    private String title;

    private String description;
    private List<String> characterIds;

    @NotBlank(message = "Story ID must not be empty")
    private String storyId;

    private List<BaseSceneBlock> sceneBlocks;
}
