package com.example.Scripter.web.dto.story;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateStoryDto {
    @NotBlank(message = "Story title must not be empty")
    private String title;
    private String description;

    @NotBlank(message = "User ID must not be empty")
    private String userId;
}
