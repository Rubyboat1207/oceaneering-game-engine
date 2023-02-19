package rubyboat.oceaneer.math;

public class Vector2i {
    public int x;
    public int y;

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2i() {
        this(0, 0);
    }

    public void add(Vector2i vec) {
        x += vec.x;
        y += vec.y;
    }

    public void add(Vector2f vec) {
        x += vec.getX();
        y += vec.getY();
    }
}
