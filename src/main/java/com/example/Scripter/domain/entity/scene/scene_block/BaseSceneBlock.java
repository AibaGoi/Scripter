package com.example.Scripter.domain.entity.scene.scene_block;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SubheadingSceneBlock.class, name = "SUBHEADING"),
        @JsonSubTypes.Type(value = ActionSceneBlock.class, name = "ACTION"),
        @JsonSubTypes.Type(value = ShotSceneBlock.class, name = "SHOT"),
        @JsonSubTypes.Type(value = TransitionSceneBlock.class, name = "TRANSITION"),
        @JsonSubTypes.Type(value = DialogueSceneBlock.class, name = "DIALOGUE")
})
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseSceneBlock {
    @JsonProperty("type")
    private SceneBlockType type;

    @JsonProperty("content")
    private String content;

}
