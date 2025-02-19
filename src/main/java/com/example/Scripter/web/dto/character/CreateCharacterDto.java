package com.example.Scripter.web.dto.character;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateCharacterDto {
    @NotBlank(message = "Character name must not be empty")
    private String name;
    private String description;

    @NotBlank(message = "Story ID must not be empty")
    private String storyId;
    private List<String> sceneIds;
}
