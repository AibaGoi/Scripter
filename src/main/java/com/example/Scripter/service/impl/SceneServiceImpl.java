package com.example.Scripter.service.impl;

import com.example.Scripter.domain.entity.character.Character;
import com.example.Scripter.domain.entity.scene.Scene;
import com.example.Scripter.domain.entity.scene.scene_block.BaseSceneBlock;
import com.example.Scripter.domain.entity.scene.scene_block.DialogueSceneBlock;
import com.example.Scripter.domain.entity.story.Story;
import com.example.Scripter.exception.NotFoundException;
import com.example.Scripter.repository.CharacterRepository;
import com.example.Scripter.repository.SceneRepository;
import com.example.Scripter.service.SceneService;
import com.example.Scripter.service.StoryService;
import com.example.Scripter.web.dto.scene.CreateSceneDto;
import com.example.Scripter.web.dto.scene.UpdateSceneDto;
import com.example.Scripter.web.mappers.SceneMapper;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SceneServiceImpl implements SceneService {

    private final StoryService storyService;
    private final SceneRepository sceneRepository;
    private final SceneMapper sceneMapper;
    private final CharacterRepository characterRepository;

    @Override
    public Scene getById(String id) {
        return sceneRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Scene not found"));
    }

    @Transactional
    @Override
    public Scene create(CreateSceneDto sceneDto) {
        Scene scene = sceneMapper.toEntity(sceneDto);

        validateCharacters(scene.getCharacters());

        if (scene.getSceneBlocks() != null && !scene.getSceneBlocks().isEmpty()) {
            validateSceneBlocks(scene.getSceneBlocks());
        } else {
            scene.setSceneBlocks(new ArrayList<>());
        }

        scene = sceneRepository.save(scene);
        storyService.addSceneToStory(scene);
        return scene;
    }

    @Override
    public Scene update(UpdateSceneDto sceneDto) {
        Scene scene = getById(sceneDto.getId());

        if (sceneDto.getTitle() != null)
            scene.setTitle(sceneDto.getTitle());

        if (sceneDto.getDescription() != null)
            scene.setDescription(sceneDto.getDescription());

        if (sceneDto.getCharacters() != null)
            scene.setCharacters(sceneDto.getCharacters());

        if (sceneDto.getSceneBlocks() != null) {
            validateSceneBlocks(sceneDto.getSceneBlocks());
            scene.setSceneBlocks(sceneDto.getSceneBlocks());
        }

        return sceneRepository.save(scene);
    }

    @Transactional
    @Override
    public void delete(String id) {
        Scene scene = getById(id);
        storyService.removeSceneFromStory(scene);
        sceneRepository.delete(scene);
    }

    @Override
    public List<Scene> getAllScenesByStoryId(String storyId) {
        return sceneRepository.findAllByStoryId(storyId);
    }

    @Override
    public void addCharacterToScene(Character character, String sceneId) {
        Scene scene = getById(sceneId);
        scene.getCharacters().add(character.getId());
        sceneRepository.save(scene);
    }

    @Transactional
    @Override
    public void addCharacterToScenes(Character character, List<String> sceneIds) {
        List<Scene> scenes = sceneRepository.findAllById(sceneIds);

        if (scenes.size() != sceneIds.size()) {
            throw new NotFoundException("Some scenes were not found for the given story.");
        }

        for (Scene scene : scenes) {
            scene.getCharacters().add(character.getId());
        }

        sceneRepository.saveAll(scenes);
    }

    @Override
    public void removeCharacterFromScene(Character character, String sceneId) {
        Scene scene = getById(sceneId);
        scene.getCharacters().remove(character.getId());
        sceneRepository.save(scene);
    }

    @Override
    public void removeCharacterFromAllScenes(Character character) {
        Story story = storyService.getById(character.getStoryId());
        List<Scene> scenes = sceneRepository.findByIdInAndCharactersContains(story.getScenes(), character.getId());

        if (scenes.size() != story.getScenes().size()) {
            throw new NotFoundException("Some scenes were not found for the given story.");
        }

        for (Scene scene : scenes) {
            scene.getCharacters().remove(character.getId());
        }

        sceneRepository.saveAll(scenes);
    }

    private void validateCharacters(List<String> characterIds) {
        if (characterIds != null && !characterIds.isEmpty()) {
            List<Character> characters = characterRepository.findAllById(characterIds);
            if (characters.size() != characterIds.size()) {
                throw new NotFoundException("Some characters were not found.");
            }
        } else {
            characterIds = new ArrayList<>();
        }
    }

    private void validateSceneBlocks(List<BaseSceneBlock> sceneBlocks) {
        for (BaseSceneBlock block : sceneBlocks) {
            if (block instanceof DialogueSceneBlock) {
                DialogueSceneBlock dialogue = (DialogueSceneBlock) block;
                if (dialogue.getCharacterId() == null || dialogue.getCharacterId().isEmpty()) {
                    throw new ValidationException("Dialogue block must have a characterId.");
                }
                if (!characterRepository.existsById(dialogue.getCharacterId())) {
                    throw new NotFoundException("Character with ID " + dialogue.getCharacterId() + " not found.");
                }
            }
        }
    }

}
