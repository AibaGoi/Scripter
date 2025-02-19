package com.example.Scripter.domain.entity.scene.scene_block;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum SceneBlockType {
    SUBHEADING,
    ACTION,
    DIALOGUE,
    SHOT,
    TRANSITION
}
