package rubyboat.oceaneer.gamelogic.entities;

import rubyboat.oceaneer.gamelogic.GameLogicManager;
import rubyboat.oceaneer.math.Vector2i;
import rubyboat.oceaneer.rendering.SpriteType;
import rubyboat.oceaneer.rendering.entity.EntityRenderer;

public class EntityBase {
    public Vector2i position;
    public EntityBase(Vector2i position) {
        this.position = position;
        new EntityRenderer(this);
        GameLogicManager.instance.tickShout.subscribe((t) -> tick());
    }

    public SpriteType determineSprite() {
        return null;
    }

    public void tick() {
        //System.out.println(Thread.currentThread().getName());
    }
}
