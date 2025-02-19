package com.example.Scripter.domain.entity.scene.scene_block;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

@Data
@EqualsAndHashCode(callSuper = true)
@TypeAlias("ACTION")
@NoArgsConstructor
public class ActionSceneBlock extends BaseSceneBlock {
    public ActionSceneBlock(String content) {
        super(SceneBlockType.ACTION, content);
    }
}
