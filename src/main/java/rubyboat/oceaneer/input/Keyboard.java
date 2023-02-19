package rubyboat.oceaneer.input;

import rubyboat.oceaneer.gamelogic.GameLogicManager;
import rubyboat.oceaneer.math.Vector2f;
import rubyboat.oceaneer.rendering.RenderManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Keyboard implements KeyListener  {
    HashMap<Integer, Boolean> keys = new HashMap<>();
    HashMap<Integer, Boolean> keysDown = new HashMap<>();


    public Keyboard(GameLogicManager gameLogicManager, RenderManager renderManager) {
        renderManager.screenRenderer.window.addKeyListener(this);
        gameLogicManager.tickShout.subscribe(sb -> tick(), -100);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys.put(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys.put(e.getKeyCode(), false);
    }

    void tick() {
        var iterator = keys.entrySet().iterator();
        while(iterator.hasNext()) {
            var entry = iterator.next();

            if(keysDown.get(entry.getKey())) {
                keys.put(entry.getKey(), false);
            }

            if(!keysDown.get(entry.getKey()) && entry.getValue()) {
                keys.put(entry.getKey(), true);
            }
        }
    }

    public boolean getKeyDown(int keycode) {
        return keysDown.get(keycode);
    }

    public boolean getKey(int keycode) {
        return keys.getOrDefault(keycode, false);
    }

    public Vector2f getMovementVector() {
        var vector = new Vector2f(0,0);

        vector.setX(
            (getKey(KeyEvent.VK_D) || getKey(KeyEvent.VK_RIGHT) ? 1 : 0)
                -
            (getKey(KeyEvent.VK_A) || getKey(KeyEvent.VK_LEFT) ? 1 : 0)
        );
        vector.setY(
            (getKey(KeyEvent.VK_S) || getKey(KeyEvent.VK_DOWN) ? 1 : 0)
                -
            (getKey(KeyEvent.VK_W) || getKey(KeyEvent.VK_UP) ? 1 : 0)
        );

        return vector;
    }
}
