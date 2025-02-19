package com.example.Scripter.domain.entity.scene.scene_block;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

@Data
@EqualsAndHashCode(callSuper = true)
@TypeAlias("SUBHEADING")
@NoArgsConstructor
public class SubheadingSceneBlock extends BaseSceneBlock {
    public SubheadingSceneBlock(String content) {
        super(SceneBlockType.SUBHEADING, content);
    }
}
