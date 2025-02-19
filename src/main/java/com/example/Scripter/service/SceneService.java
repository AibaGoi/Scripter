package com.example.Scripter.service;

import com.example.Scripter.domain.entity.character.Character;
import com.example.Scripter.domain.entity.scene.Scene;
import com.example.Scripter.web.dto.scene.CreateSceneDto;
import com.example.Scripter.web.dto.scene.UpdateSceneDto;

import java.util.List;

public interface SceneService {
    Scene getById(String id);

    Scene create(CreateSceneDto sceneDto);

    Scene update(UpdateSceneDto sceneDto);

    void delete(String id);

    List<Scene> getAllScenesByStoryId(String storyId);

    void addCharacterToScene(Character character, String sceneId);

    void addCharacterToScenes(Character character, List<String> sceneIds);

    void removeCharacterFromScene(Character character, String sceneId);

    void removeCharacterFromAllScenes(Character character);
}
