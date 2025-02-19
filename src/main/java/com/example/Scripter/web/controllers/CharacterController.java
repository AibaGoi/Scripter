package com.example.Scripter.web.controllers;

import com.example.Scripter.domain.entity.character.Character;
import com.example.Scripter.service.CharacterService;
import com.example.Scripter.web.dto.character.CreateCharacterDto;
import com.example.Scripter.web.dto.character.UpdateCharacterDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/characters")
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacter(@PathVariable String id) {
        return ResponseEntity.ok(characterService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody @Valid CreateCharacterDto characterDto) {
        Character character = characterService.create(characterDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(character);
    }

    @PutMapping
    public ResponseEntity<Character> updateCharacter(@RequestBody @Valid UpdateCharacterDto characterDto) {
        return ResponseEntity.ok(characterService.update(characterDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable String id) {
        characterService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all/{storyId}")
    public ResponseEntity<List<Character>> getAllByStoryId(@PathVariable String storyId) {
        List<Character> characters = characterService.getAllByStoryId(storyId);
        return characters.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(characters);
    }

    @GetMapping("/scene/{sceneId}")
    public ResponseEntity<List<Character>> getCharactersBySceneId(@PathVariable String sceneId) {
        List<Character> characters = characterService.getCharactersBySceneId(sceneId);
        return characters.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(characters);
    }
}
