package rubyboat.oceaneer.gamelogic;

import rubyboat.oceaneer.gamelogic.entities.PlayerEntity;
import rubyboat.oceaneer.input.Keyboard;
import rubyboat.oceaneer.rendering.RenderManager;
import rubyboat.oceaneer.rendering.debug.DebugMenu;

public class GameInitializer {
    public void onInitialized(GameLogicManager gameLogicManager, RenderManager renderManager) {
        gameLogicManager.keyboard = new Keyboard(gameLogicManager, renderManager);

        new PlayerEntity();
        new DebugMenu();
    }
}
