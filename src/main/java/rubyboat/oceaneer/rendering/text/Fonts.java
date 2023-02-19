package rubyboat.oceaneer.rendering.text;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Fonts {
    public static Font REGULAR;
    public static final String BOLD = "/fonts/bold.ttf";
    public static final String ITALIC = "/fonts/italic.ttf";
    public static final String BOLD_ITALIC = "/fonts/bolditalic.ttf";

    static {
        try {
            REGULAR = Font.createFont(Font.TRUETYPE_FONT, new File("/fonts/regular.ttf"));
        } catch (Exception ignored){

        }
    }
}
