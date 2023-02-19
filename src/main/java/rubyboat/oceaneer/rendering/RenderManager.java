package rubyboat.oceaneer.rendering;

import rubyboat.oceaneer.ThreadManager;
import rubyboat.oceaneer.data.Identifier;
import rubyboat.oceaneer.gamelogic.entities.PlayerEntity;
import rubyboat.oceaneer.math.Vector2i;
import rubyboat.oceaneer.rendering.layers.LayerManager;
import rubyboat.oceaneer.rendering.text.Text;
import rubyboat.oceaneer.rendering.tiles.TileRenderer;

import java.util.Timer;

public class RenderManager implements Runnable {
    static long fps;
    public static RenderManager instance;
    public ScreenRenderer screenRenderer;

    TileRenderer tileRenderer;
    LayerManager layerManager;

    boolean running = true;
    Timer timer;
    public GameView gameView;

    public RenderManager() {
        instance = this;
        screenRenderer = new ScreenRenderer();
        timer = new Timer();
        gameView = new GameView();
        layerManager = new LayerManager(this);
        ThreadManager.instance.setRenderThreadInitialized();
    }

    @Override
    public void run() {
        //This runs, and if it occurs overlapping... too bad
        timer.scheduleAtFixedRate(new java.util.TimerTask() {
            long lastExecution = System.currentTimeMillis();
            public void run() {
                long timeSinceLastExecution = System.currentTimeMillis() - lastExecution;
                lastExecution = System.currentTimeMillis();
                fps = Math.round(1000. / timeSinceLastExecution);

                screenRenderer.panel.repaint();
                layerManager.renderConsecutive();
            }
        }, 0,  16);
    }

    public void blit(Sprite sprite) {
        screenRenderer.blit(sprite);
    }
    public void text(String text, Vector2i position) {
        screenRenderer.text(new Text(text, position));
    }

    public static long getFPS() {
        return fps;
    }
}
