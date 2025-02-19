package com.example.Scripter.web.dto.character;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdateCharacterDto {
    @NotBlank(message = "ID must not be empty")
    private String id;

    @Size(min = 1, message = "Character name must not be empty")
    private String name;
    private String description;
    private List<String> sceneIds;
}
