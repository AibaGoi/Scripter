package com.example.Scripter.service.impl;

import com.example.Scripter.domain.entity.character.Character;
import com.example.Scripter.domain.entity.scene.Scene;
import com.example.Scripter.domain.entity.story.Story;
import com.example.Scripter.exception.NotFoundException;
import com.example.Scripter.repository.CharacterRepository;
import com.example.Scripter.repository.SceneRepository;
import com.example.Scripter.repository.StoryRepository;
import com.example.Scripter.service.StoryService;
import com.example.Scripter.web.dto.story.CreateStoryDto;
import com.example.Scripter.web.dto.story.UpdateStoryDto;
import com.example.Scripter.web.mappers.StoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;
    private final SceneRepository sceneRepository;
    private final CharacterRepository characterRepository;
    private final StoryMapper storyMapper;

    @Override
    public Story getById(String id) {
        return storyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Story not found"));
    }

    @Override
    public Story create(CreateStoryDto storyDto) {
        Story story = storyMapper.toEntity(storyDto);
        return storyRepository.save(story);
    }

    @Override
    public Story update(UpdateStoryDto storyDto) {
        Story story = getById(storyDto.getId());

        if (storyDto.getTitle() != null)
            story.setTitle(storyDto.getTitle());

        if (storyDto.getDescription() != null)
            story.setDescription(storyDto.getDescription());

        if (storyDto.getScenes() != null)
            story.setScenes(storyDto.getScenes());

        if (storyDto.getCharacters() != null)
            story.setCharacters(storyDto.getCharacters());

        return storyRepository.save(story);
    }

    @Transactional
    @Override
    public void delete(String id) {
        Story story = getById(id);
        sceneRepository.deleteAllById(story.getScenes());
        characterRepository.deleteAllById(story.getCharacters());
        storyRepository.delete(story);
    }

    @Override
    public List<Story> getAllStories(String userId) {
        return storyRepository.findAllStoriesByUserId(userId);
    }

    @Override
    public void addSceneToStory(Scene scene) {
        Story story = getById(scene.getStoryId());
        story.getScenes().add(scene.getId());
        storyRepository.save(story);
    }

    @Override
    public void addCharacterToStory(Character character) {
        Story story = getById(character.getStoryId());
        story.getCharacters().add(character.getId());
        storyRepository.save(story);
    }

    @Override
    public void removeSceneFromStory(Scene scene) {
        Story story = getById(scene.getStoryId());
        story.getScenes().remove(scene.getId());
        storyRepository.save(story);
    }

    @Override
    public void removeCharacterFromStory(Character character) {
        Story story = getById(character.getStoryId());
        story.getCharacters().remove(character.getId());
        storyRepository.save(story);
    }
}
