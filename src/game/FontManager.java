package game;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontManager {
    private static Font flappyBirdFont, cheriFont;
    static {
        try {
            flappyBirdFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/assets/flappy_bird_font.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(flappyBirdFont);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            cheriFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/assets/CHERI___.TTF"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(cheriFont);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Font getFlappyBirdFont(int size){ return flappyBirdFont.deriveFont(Font.PLAIN,size); }
    public static Font getMinecraftFont(int size) { return cheriFont.deriveFont(Font.PLAIN, size); }
}
