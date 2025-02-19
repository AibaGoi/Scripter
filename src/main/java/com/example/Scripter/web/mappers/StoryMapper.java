package com.example.Scripter.web.mappers;

import com.example.Scripter.domain.entity.story.Story;
import com.example.Scripter.web.dto.story.CreateStoryDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class StoryMapper {
    public Story toEntity(CreateStoryDto storyDto) {
        Story story = Story.builder()
                .title(storyDto.getTitle())
                .description(storyDto.getDescription())
                .userId(storyDto.getUserId())
                .scenes(new ArrayList<>())
                .characters(new ArrayList<>())
                .build();
        return story;
    }
}
