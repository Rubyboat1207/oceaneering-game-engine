package rubyboat.oceaneer.rendering.text;

import rubyboat.oceaneer.math.Vector2i;

import java.awt.*;
import java.io.File;

public class Text {
    String text;
    Vector2i position;
    Color color;
    Font font;
    public Text(String text, Vector2i position) {
        this.position = position;
        this.text = text;
        color = Color.WHITE;
        font = Fonts.REGULAR;
    }

    public String getText() {
        return text;
    }

    public Vector2i getPosition() {
        return position;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Font getFont() {
        return font;
    }
}
