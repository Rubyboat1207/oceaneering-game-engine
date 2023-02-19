package rubyboat.oceaneer.rendering;

import rubyboat.oceaneer.data.Identifier;
import rubyboat.oceaneer.math.Vector2i;

import java.awt.*;

public class Sprite {
    private Image image;
    public static int SPRITES;
    public Vector2i position;
    public int uuid;
    SpriteType type;


    public Sprite(Vector2i pos, SpriteType type) {
        this.position = pos;
        this.uuid = SPRITES;
        SPRITES++;
        this.type = type;

        type.GatherImage();
    }
    public Image getImage() {
        return type.image;
    }

    public int getWidth() {
        return type.width;
    }

    public int getHeight() {
        return type.height;
    }
}
