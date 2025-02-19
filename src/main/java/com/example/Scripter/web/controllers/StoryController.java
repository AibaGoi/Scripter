package com.example.Scripter.web.controllers;

import com.example.Scripter.domain.entity.story.Story;
import com.example.Scripter.service.StoryService;
import com.example.Scripter.web.dto.story.CreateStoryDto;
import com.example.Scripter.web.dto.story.UpdateStoryDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stories")
@AllArgsConstructor
public class StoryController {

    private final StoryService storyService;

    @GetMapping("/{id}")
    public ResponseEntity<Story> getStory(@PathVariable String id) {
        return ResponseEntity.ok(storyService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Story> createStory(@RequestBody @Valid CreateStoryDto storyDto) {
        Story story = storyService.create(storyDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(story);
    }

    @PutMapping
    public ResponseEntity<Story> updateStory(@RequestBody @Valid UpdateStoryDto storyDto) {
        return ResponseEntity.ok(storyService.update(storyDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStory(@PathVariable String id) {
        storyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<Story>> getAllStories(@PathVariable String userId) {
        List<Story> stories = storyService.getAllStories(userId);
        return stories.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(stories);
    }

}
