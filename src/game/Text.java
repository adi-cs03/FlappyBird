package game;

import java.awt.*;

public class Text {
    private final String titleName = "Flappy Bird";
    private final String gameOverMessage = "Game Over";
    Font flappyBirdFont, minecraftFont;

    Text() {
        flappyBirdFont = FontManager.getFlappyBirdFont(110);
        minecraftFont = FontManager.getMinecraftFont(60);
    }
    void drawTitle(Graphics g) {
        g.setFont(flappyBirdFont);
        g.setColor(Color.WHITE);
        FontMetrics fontMetrics = g.getFontMetrics();
        int x = (Game.windowWidth - fontMetrics.stringWidth(titleName)) / 2;
        int y = 200;
        g.drawString(titleName,x ,y);
    }

    void drawGameOverMessage(Graphics g) {
        g.setFont(minecraftFont);
        g.setColor(Color.WHITE);
        FontMetrics fontMetrics = g.getFontMetrics();
        int x = (Game.windowWidth - fontMetrics.stringWidth(gameOverMessage)) / 2;
        int y = 200;
        g.drawString(gameOverMessage,x ,y);
    }

    void drawScoreText(Graphics g) {
        g.setFont(minecraftFont.deriveFont(Font.PLAIN, 40));
        g.setColor(Color.WHITE);
        g.drawString("Score:",5,42);
    }

    void drawScore(Graphics g, double score) {
        g.setFont(minecraftFont.deriveFont(Font.PLAIN, 40));
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf((int)score),140,42);
    }
}
