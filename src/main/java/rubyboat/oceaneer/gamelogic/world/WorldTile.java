package rubyboat.oceaneer.gamelogic.world;

import rubyboat.oceaneer.math.Vector2i;
import rubyboat.oceaneer.rendering.tiles.Tile;

public class WorldTile {
    Vector2i position;
    World world;
    Tile tile;

    public WorldTile(Vector2i position, World world, Tile tile) {
        this.position = position;
        this.world = world;
        this.tile = tile;
    }

    public void render() {

    }

    public static void getTileSize() {

    }
}
