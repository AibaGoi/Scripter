package com.example.Scripter.web.controllers;

import com.example.Scripter.domain.entity.scene.Scene;
import com.example.Scripter.service.SceneService;
import com.example.Scripter.web.dto.scene.CreateSceneDto;
import com.example.Scripter.web.dto.scene.UpdateSceneDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/scenes")
@AllArgsConstructor
public class SceneController {

    private final SceneService sceneService;

    @GetMapping("/{id}")
    public ResponseEntity<Scene> getScene(@PathVariable String id) {
        return ResponseEntity.ok(sceneService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Scene> createScene(@RequestBody @Valid CreateSceneDto sceneDto) {
        Scene scene = sceneService.create(sceneDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(scene);
    }

    @PutMapping
    public ResponseEntity<Scene> updateScene(@RequestBody @Valid UpdateSceneDto sceneDto) {
        return ResponseEntity.ok(sceneService.update(sceneDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScene(@PathVariable String id) {
        sceneService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/story/all/{storyId}")
    public ResponseEntity<List<Scene>> getAllScenes(@PathVariable String storyId) {
        List<Scene> scenes = sceneService.getAllScenesByStoryId(storyId);
        return scenes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(scenes);
    }
}
