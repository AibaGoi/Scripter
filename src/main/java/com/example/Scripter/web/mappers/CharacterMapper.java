package com.example.Scripter.web.mappers;

import com.example.Scripter.domain.entity.character.Character;
import com.example.Scripter.web.dto.character.CreateCharacterDto;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {
    public Character toEntity(CreateCharacterDto characterDto) {
        return Character.builder()
                .name(characterDto.getName())
                .description(characterDto.getDescription())
                .storyId(characterDto.getStoryId())
                .build();
    }
}
