package com.example.Scripter.service.impl;

import com.example.Scripter.domain.entity.character.Character;
import com.example.Scripter.domain.entity.scene.Scene;
import com.example.Scripter.domain.entity.story.Story;
import com.example.Scripter.exception.NotFoundException;
import com.example.Scripter.repository.CharacterRepository;
import com.example.Scripter.service.CharacterService;
import com.example.Scripter.service.SceneService;
import com.example.Scripter.service.StoryService;
import com.example.Scripter.web.dto.character.CreateCharacterDto;
import com.example.Scripter.web.dto.character.UpdateCharacterDto;
import com.example.Scripter.web.mappers.CharacterMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final StoryService storyService;
    private final SceneService sceneService;
    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    @Override
    public Character getById(String id) {
        Character character = characterRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Character not found"));
        return character;
    }

    @Transactional
    @Override
    public Character create(CreateCharacterDto characterDto) {
        Character character = characterMapper.toEntity(characterDto);
        character = characterRepository.save(character);

        if (characterDto.getSceneIds() != null && !characterDto.getSceneIds().isEmpty())
            sceneService.addCharacterToScenes(character, characterDto.getSceneIds());

        storyService.addCharacterToStory(character);
        return character;
    }

    @Override
    public Character update(UpdateCharacterDto characterDto) {
        Character character = getById(characterDto.getId());

        if (characterDto.getName() != null)
            character.setName(characterDto.getName());

        if (characterDto.getDescription() != null)
            character.setDescription(characterDto.getDescription());

        return characterRepository.save(character);
    }

    @Transactional
    @Override
    public void delete(String id) {
        Character character = getById(id);
        storyService.removeCharacterFromStory(character);
        sceneService.removeCharacterFromAllScenes(character);
        characterRepository.delete(character);
    }

    @Override
    public List<Character> getAllByStoryId(String storyId) {
        Story story = storyService.getById(storyId);
        return characterRepository.findAllById(story.getCharacters());
    }

    @Override
    public List<Character> getCharactersBySceneId(String sceneId) {
        Scene scene = sceneService.getById(sceneId);
        return characterRepository.findAllById(scene.getCharacters());
    }
}
