package rubyboat.oceaneer.gamelogic.entities;

import rubyboat.oceaneer.data.Identifier;
import rubyboat.oceaneer.gamelogic.GameLogicManager;
import rubyboat.oceaneer.input.Keyboard;
import rubyboat.oceaneer.math.Vector2i;
import rubyboat.oceaneer.rendering.SpriteType;

public class PlayerEntity extends EntityBase {
    SpriteType FORWARD = new SpriteType(32, 32, new Identifier("player"));

    public PlayerEntity() {
        super(new Vector2i(100, 100));
    }

    @Override
    public SpriteType determineSprite() {
        return FORWARD;
    }

    @Override
    public void tick() {
        position.add(GameLogicManager.instance.keyboard.getMovementVector());
    }
}
