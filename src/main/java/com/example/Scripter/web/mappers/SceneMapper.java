package com.example.Scripter.web.mappers;

import com.example.Scripter.domain.entity.scene.Scene;
import com.example.Scripter.web.dto.scene.CreateSceneDto;
import org.springframework.stereotype.Component;

@Component
public class SceneMapper {
    public Scene toEntity(CreateSceneDto sceneDto) {
        return Scene.builder()
                .title(sceneDto.getTitle())
                .description(sceneDto.getDescription())
                .storyId(sceneDto.getStoryId())
                .characters(sceneDto.getCharacterIds())
                .sceneBlocks(sceneDto.getSceneBlocks())
                .build();
    }




}
