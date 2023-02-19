package rubyboat.oceaneer.rendering.debug;

import rubyboat.oceaneer.gamelogic.GameLogicManager;
import rubyboat.oceaneer.math.Vector2i;
import rubyboat.oceaneer.rendering.RenderManager;
import rubyboat.oceaneer.rendering.layers.LayerManager;

public class DebugMenu {
    public DebugMenu() {
        LayerManager.instance.getLayer("Debug").subscribe((sb) -> {render();});
    }
    public static void render() {
        RenderManager.instance.text("Debug Menu", new Vector2i(0, 20));
        RenderManager.instance.text("TPS: " + GameLogicManager.getLatestTickrate(), new Vector2i(0, 40));
        RenderManager.instance.text("FPS: " + RenderManager.getFPS(), new Vector2i(0, 60));
    }
}
