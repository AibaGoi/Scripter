package com.example.Scripter.domain.entity.scene.scene_block;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

@Data
@EqualsAndHashCode(callSuper = true)
@TypeAlias("TRANSITION")
@NoArgsConstructor
public class TransitionSceneBlock extends BaseSceneBlock {
    public TransitionSceneBlock(String content) {
        super(SceneBlockType.TRANSITION, content);
    }
}
