package rubyboat.oceaneer.gamelogic.world.tiles;

import rubyboat.oceaneer.data.Identifier;
import rubyboat.oceaneer.rendering.SpriteType;
import rubyboat.oceaneer.rendering.tiles.Tile;

public class Tiles {
    public static Tile grass = new Tile(new SpriteType(32, 32, new Identifier("tiles/grass")));
    public static Tile dirt = new Tile(new SpriteType(32, 32, new Identifier("tiles/dirt")));
    public static Tile stone = new Tile(new SpriteType(32, 32, new Identifier("tiles/stone")));
    public static Tile water = new Tile(new SpriteType(32, 32, new Identifier("tiles/water")));
    public static Tile sand = new Tile(new SpriteType(32, 32, new Identifier("tiles/sand")));
    public static Tile sandstone = new Tile(new SpriteType(32, 32, new Identifier("tiles/sandstone")));
    public static Tile wood = new Tile(new SpriteType(32, 32, new Identifier("tiles/wood")));
    public static Tile leaves = new Tile(new SpriteType(32, 32, new Identifier("tiles/leaves")));
    public static Tile glass = new Tile(new SpriteType(32, 32, new Identifier("tiles/glass")));
    public static Tile bedrock = new Tile(new SpriteType(32, 32, new Identifier("tiles/bedrock")));
    public static Tile air = new Tile(new SpriteType(32, 32, new Identifier("tiles/grass")));
}
