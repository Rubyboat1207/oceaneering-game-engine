package rubyboat.oceaneer.rendering;

import rubyboat.oceaneer.data.Identifier;

import java.awt.*;

public class SpriteType {
    int width;
    int height;
    Image image;
    Identifier id;

    public SpriteType(int width, int height, Identifier id) {
        this.width = width;
        this.height = height;
        this.id = id;
    }

    public void GatherImage(boolean force) {
        if(shouldGatherImage() || force) {
            String path = "src/main/resources/assets/" + id.getNamespace() + "/textures/" + id.getPath() + ".png";
            image = Toolkit.getDefaultToolkit().getImage(path);
            System.out.println(path);
        }
    }

    public void GatherImage() {
        GatherImage(false);
    }

    public boolean shouldGatherImage() {
        return image == null;
    }
}
