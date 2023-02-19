package rubyboat.oceaneer.rendering.layers;

import rubyboat.oceaneer.events.IgnoredShoutBack;
import rubyboat.oceaneer.rendering.RenderManager;

import java.util.ArrayList;

public class LayerManager {
    public static LayerManager instance;
    String[] names = {
        "Background",
        "Tile",
        "Entity",
        "Overlay",
        "GUI",
        "Screen",
        "Debug"
    };
    ArrayList<RenderLayer> layers = new ArrayList<>();

    public LayerManager(RenderManager renderManager) {
        for(int i = 0; i < names.length; i++) {
            layers.add(new RenderLayer(
                i,
                names[i],
                true,
                renderManager,
                new LayerRenderShout(new IgnoredShoutBack())
            ));
        }
        instance = this;
    }

    public RenderLayer getLayer(int order) {
        return layers.get(order);
    }

    public RenderLayer getLayer(String name) {
        for (RenderLayer layer : layers) {
            if (layer.name.equals(name)) {
                return layer;
            }
        }
        return null;
    }

    public void renderConsecutive() {
        for (RenderLayer layer : layers) {
            if (layer.enabled) {
                layer.renderLayer();
            }
        }
    }

    public void setLayerEnabled(int order, boolean enabled) {
        layers.get(order).enabled = enabled;
    }

    public void setLayerEnabled(String name, boolean enabled) {
        getLayer(name).enabled = enabled;
    }

    public void toggleLayer(int order) {
        RenderLayer layer = layers.get(order);

        layer.enabled = !layer.enabled;
    }

    public void toggleLayer(String name) {
        RenderLayer layer = getLayer(name);

        layer.enabled = !layer.enabled;
    }
}
