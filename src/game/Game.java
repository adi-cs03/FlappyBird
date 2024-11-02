package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements ActionListener, KeyListener {
    static final int windowWidth = 360, windowHeight = 640;
    private final Image backgroundImage;
    private Bird bird;
    private Pipes pipeHandler;
    private Timer frameTimer, addPipesTimer;
    private Text text;
    private boolean gameStarted;
    private boolean gameOver;
    static double score;

    Game() {
        //set the preferred size of the game window
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));

        setFocusable(true);
        addKeyListener(this);

        //load background image
        ImageIcon backgroundIcon = new ImageIcon("src/assets/background_image.png");
        backgroundImage = backgroundIcon.getImage();

        //initialising the title object
        text = new Text();

        //initialising the bird object
        bird = new Bird();

        //initialising the pipes object
        pipeHandler = new Pipes();

        //timer for updating the frames of the game (refresh rate)
        frameTimer = new Timer(7, this);
        frameTimer.start();

        //timer for adding pipes to the frame
        addPipesTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add pipes here
                pipeHandler.addPipe();
            }
        });
        addPipesTimer.start();

        gameStarted = false;
        gameOver = false;

        score = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //draw the background image
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        //draw the title
        if (!gameStarted) text.drawTitle(g);

        //drawing the bird
        bird.draw(g);

        //drawing the pipes
        if(gameStarted){
            pipeHandler.drawPipes(g);
            text.drawScoreText(g);
            text.drawScore(g,score);
        }

        if (gameStarted && gameOver) text.drawGameOverMessage(g);
    }

    // Handles timer events to update game state and repaint frames.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameStarted) {
            bird.fall(); //simulates birds fall due to gravity
            if (bird.y >= windowHeight || pipeHandler.collision(bird)) { //bird fell below the game window or collided with pipe
                gameOver = true;
            }
            pipeHandler.move(bird);
        }
        if(gameOver) {
            frameTimer.stop();
            addPipesTimer.stop();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!gameStarted) gameStarted = true;
            bird.flap();

            if (gameOver) {
                score = 0;
                gameOver = false;
                frameTimer.start();
                addPipesTimer.start();
                bird.reset();
                pipeHandler.reset();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
