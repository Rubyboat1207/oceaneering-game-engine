package rubyboat.oceaneer.rendering;

import rubyboat.oceaneer.rendering.frames.GamePanel;
import rubyboat.oceaneer.rendering.text.Text;

import javax.swing.*;

public class ScreenRenderer {
    public JFrame window;
    public GamePanel panel;

    public ScreenRenderer() {
        initializeScreen();
    }

    public void initializeScreen() {
        window = new JFrame("Oceaneer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);

        panel = new GamePanel(RenderManager.instance);
        window.add(panel);
        window.pack();
        window.setFocusable(true);

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public void blit(Sprite sprite) {
        panel.graphicQueue.add(sprite);
    }

    public void text(Text text) {
        panel.textQueue.add(text);
    }
}
