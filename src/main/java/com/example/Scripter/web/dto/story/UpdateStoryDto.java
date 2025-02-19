package com.example.Scripter.web.dto.story;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdateStoryDto {
    @NotBlank(message = "ID must not be empty")
    private String id;

    @Size(min = 1, message = "Story title must not be empty")
    private String title;

    private String description;
    private List<String> scenes;
    private List<String> characters;
}
