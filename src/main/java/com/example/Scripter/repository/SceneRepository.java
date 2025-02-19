package com.example.Scripter.repository;

import com.example.Scripter.domain.entity.scene.Scene;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SceneRepository extends MongoRepository<Scene, String> {
    List<Scene> findAllByStoryId(String storyId);

    List<Scene> findByIdInAndCharactersContains(List<String> ids, String characterId);

}
