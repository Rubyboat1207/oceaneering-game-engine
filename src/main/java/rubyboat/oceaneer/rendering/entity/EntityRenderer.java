package rubyboat.oceaneer.rendering.entity;

import rubyboat.oceaneer.gamelogic.entities.EntityBase;
import rubyboat.oceaneer.rendering.Sprite;
import rubyboat.oceaneer.rendering.SpriteType;
import rubyboat.oceaneer.rendering.layers.LayerManager;

public class EntityRenderer {
    EntityBase entity;

    public EntityRenderer(EntityBase entity) {
        this.entity = entity;
        LayerManager.instance.getLayer("Entity").subscribe((sb) -> render());
    }

    void render() {
        Sprite sprite = new Sprite(entity.position, entity.determineSprite());
        LayerManager.instance.getLayer("Entity").renderSprite(sprite);
    }
}
