package com.example.Scripter.repository;

import com.example.Scripter.domain.entity.character.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CharacterRepository extends MongoRepository<Character, String> {
    List<Character> findByStoryId(String storyId);
}
