package com.example.Scripter.service;

import com.example.Scripter.domain.entity.character.Character;
import com.example.Scripter.web.dto.character.CreateCharacterDto;
import com.example.Scripter.web.dto.character.UpdateCharacterDto;

import java.util.List;

public interface CharacterService {

    Character getById(String id);

    Character create(CreateCharacterDto characterDto);

    Character update(UpdateCharacterDto characterDto);

    void delete(String id);

    List<Character> getAllByStoryId(String storyId);

    List<Character> getCharactersBySceneId(String sceneId);
}
