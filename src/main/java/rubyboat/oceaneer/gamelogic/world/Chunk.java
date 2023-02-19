package rubyboat.oceaneer.gamelogic.world;

import rubyboat.oceaneer.gamelogic.entities.EntityBase;

import java.util.ArrayList;

public class Chunk {
    public static final int CHUNK_SIZE = 16;
    public static final int TILE_SIZE = 32;

    private WorldTile[][] tiles;
    private ArrayList<EntityBase> entities;

    public Chunk() {
        tiles = new WorldTile[CHUNK_SIZE][CHUNK_SIZE];
        entities = new ArrayList<EntityBase>();
    }

    public void RenderChunk() {
        for (int x = 0; x < CHUNK_SIZE; x++) {
            for (int y = 0; y < CHUNK_SIZE; y++) {
                tiles[x][y].render();
            }
        }
    }

    public void IsOnScreen() {

    }
}
