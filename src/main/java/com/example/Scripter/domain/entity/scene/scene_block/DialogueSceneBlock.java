package com.example.Scripter.domain.entity.scene.scene_block;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

@EqualsAndHashCode(callSuper = true)
@Data
@TypeAlias("DIALOGUE")
@AllArgsConstructor
@NoArgsConstructor
public class DialogueSceneBlock extends BaseSceneBlock {
    private String characterId;
    private String characterName;
    private String parenthetical;
    private String extension;
}
