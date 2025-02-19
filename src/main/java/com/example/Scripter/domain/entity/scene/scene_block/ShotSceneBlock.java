package com.example.Scripter.domain.entity.scene.scene_block;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

@Data
@EqualsAndHashCode(callSuper = true)
@TypeAlias("SHOT")
@NoArgsConstructor
public class ShotSceneBlock extends BaseSceneBlock {
    public ShotSceneBlock(String content) {
        super(SceneBlockType.SHOT, content);
    }
}
