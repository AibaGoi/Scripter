package com.example.Scripter.web.dto.scene;

import com.example.Scripter.domain.entity.scene.scene_block.BaseSceneBlock;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdateSceneDto {
    @NotBlank(message = "ID must not be empty")
    private String id;

    @Size(min = 1, message = "Title must not be empty")
    private String title;
    private String description;
    private List<String> characters;
    private List<BaseSceneBlock> sceneBlocks;
}
