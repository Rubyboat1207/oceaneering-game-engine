package rubyboat.oceaneer;

import rubyboat.oceaneer.gamelogic.GameInitializer;
import rubyboat.oceaneer.gamelogic.GameLogicManager;
import rubyboat.oceaneer.rendering.RenderManager;

public class ThreadManager {
    public static ThreadManager instance;
    Thread renderThread;
    boolean renderThreadInitialized = false;
    Thread gameLoopThread;
    boolean gameLoopInitialized = false;

    public ThreadManager() {
        instance = this;
        gameLoopThread = new Thread(new GameLogicManager());
        gameLoopThread.setName("GameLoopThread");
        gameLoopThread.start();

        renderThread = new Thread(new RenderManager());
        renderThread.setName("RenderThread");
        renderThread.start();
    }

    public void setRenderThreadInitialized() {
        renderThreadInitialized = true;
        if(gameLoopInitialized) {
            OnThreadsInitialized();
        }
    }

    public void setGameLoopInitialized() {
        gameLoopInitialized = true;
        if(renderThreadInitialized) {
            OnThreadsInitialized();
        }
    }

    public void OnThreadsInitialized() {
        new GameInitializer().onInitialized(GameLogicManager.instance, RenderManager.instance);
    }
}
