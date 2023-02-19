package rubyboat.oceaneer;

import rubyboat.oceaneer.rendering.RenderManager;
import rubyboat.oceaneer.rendering.ScreenRenderer;

public class Main {
    public static ThreadManager threadManager;

    public static void main(String[] args) {
        threadManager = new ThreadManager();
    }
}