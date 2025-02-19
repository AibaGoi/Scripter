package com.example.Scripter.service;

import com.example.Scripter.domain.entity.character.Character;
import com.example.Scripter.domain.entity.scene.Scene;
import com.example.Scripter.domain.entity.story.Story;
import com.example.Scripter.web.dto.story.CreateStoryDto;
import com.example.Scripter.web.dto.story.UpdateStoryDto;

import java.util.List;

public interface StoryService {
    Story getById(String id);

    Story update(UpdateStoryDto storyDto);

    Story create(CreateStoryDto storyDto);

    void delete(String id);

    List<Story> getAllStories(String userId);

    void addSceneToStory(Scene scene);

    void addCharacterToStory(Character character);

    void removeSceneFromStory(Scene scene);

    void removeCharacterFromStory(Character character);
}
