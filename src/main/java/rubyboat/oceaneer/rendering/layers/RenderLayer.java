package rubyboat.oceaneer.rendering.layers;

import rubyboat.oceaneer.events.GeneralShout;
import rubyboat.oceaneer.rendering.RenderManager;
import rubyboat.oceaneer.rendering.Sprite;

public class RenderLayer {
    public int order;
    public String name;
    public boolean enabled;

    public RenderManager renderManager;
    public LayerRenderShout shout;

    public RenderLayer(int order, String name, boolean enabled, RenderManager manager, LayerRenderShout shout) {
        this.order = order;
        this.name = name;
        this.enabled = enabled;
        this.shout = shout;
        renderManager = manager;
    }

    public void subscribe(GeneralShout.ShoutListener listener) {
        shout.subscribe(listener);
    }

    public void renderLayer() {
        shout.Invoke();
    }

    public void renderSprite(Sprite sprite) {
        renderManager.blit(sprite);
    }
}
