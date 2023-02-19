package rubyboat.oceaneer.rendering.frames;

import rubyboat.oceaneer.rendering.RenderManager;
import rubyboat.oceaneer.rendering.Sprite;
import rubyboat.oceaneer.rendering.text.Text;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    final int scale = 3;
    final Color backgroundColor = Color.BLACK;
    public ArrayList<Sprite> graphicQueue = new ArrayList<>();
    public ArrayList<Text> textQueue = new ArrayList<>();
    RenderManager renderManager;

    public GamePanel(RenderManager renderManager) {
        setPreferredSize(new Dimension(800, 600));
        setBackground(backgroundColor);
        setDoubleBuffered(true);
        this.renderManager = renderManager;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        for(int i = 0; i < graphicQueue.size(); i++) {
            Sprite sprite = graphicQueue.get(i);
            g2d.drawImage(
                sprite.getImage(),
                sprite.position.x,
                sprite.position.y,
                (int) Math.floor(sprite.getWidth() * renderManager.gameView.zoom),
                (int) Math.floor(sprite.getHeight() * renderManager.gameView.zoom),
                this
            );
        }
        graphicQueue.clear();
        for(int i = 0; i < textQueue.size(); i++) {
            Text text = textQueue.get(i);
            g2d.setColor(text.getColor());
            g2d.setFont(text.getFont());
            g2d.drawString(text.getText(), text.getPosition().x, text.getPosition().y);
        }
        textQueue.clear();
        g2d.dispose();
    }
}
