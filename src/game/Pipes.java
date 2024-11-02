package game;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Pipes {
    private final int startX = Game.windowWidth, startY = 0; //starting coordinates of the pipe
    int x,y; //coordinates of the pipe
    private final int horizontalVelocity = 2;
    private final int width = 64;
    private final int height = 512;
    private final int gap = Game.windowHeight/4;
    private boolean passed;
    private Image pipeModel;
    private ArrayList<Pipes> pipes; //array to store the pipes
    private Random random;

    //just to initialise the object in the game class
    Pipes() {
        pipes = new ArrayList<>();
    }
    Pipes(boolean upper) {
        passed = false;
        ImageIcon image;

        if (upper) //loading the upper pipe image
            image = new ImageIcon("src/assets/upper_pipe.png");
        else //loading the lower pipe image
            image = new ImageIcon("src/assets/lower_pipe.png");

        pipeModel = image.getImage();

        //setting the starting coordinates
        x = startX;
        y = startY;
    }
    public void addPipe() {
        /* creating the RANDOM Y COORDINATE of the UPPER PIPES to vary their positions in the frame
         * math.random() -> [0,1]
         * pipeHeight = 512 -> pipeHeight/2 = 256 -> pipeHeight/4 = 128
         * y = 0
         * randomY = 0 - 128 - [0,256]
         */
        int randomY = (int) (y - height /4 - Math.random()*(height /2));

        Pipes upperPipe = new Pipes(true);
        upperPipe.y = randomY;

        Pipes lowerPipe = new Pipes(false);
        lowerPipe.y = randomY + height + gap; //the lower pipe starts below the upper pipe with a constant gap in between

        pipes.add(upperPipe);
        pipes.add(lowerPipe);
    }

    public void move(Bird bird) {
        for(Pipes pipe : pipes){
            pipe.x -= horizontalVelocity;
            if(!pipe.passed && bird.x > pipe.x + pipe.width) {
                pipe.passed = true;
                Game.score += 0.5; //at once, the bird crosses 2 pipes, the upper and the lower, each giving half a point
            }
        }
    }

    public void drawPipes(Graphics g) {
        for(Pipes pipe : pipes) {
            g.drawImage(pipe.pipeModel,pipe.x, pipe.y, pipe.width, pipe.height, null);
        }
    }

    public boolean collision (Bird bird) {
        for(Pipes pipe1 : this.pipes) {
            if(  bird.x < pipe1.x + bird.width && //bird's top left corner does not reach pipe's top right corner
                 bird.x + bird.width > pipe1.x && //bird's top right corner passes pipe's top left corner
                 bird.y < pipe1.y + pipe1.height && //bird's top left corener does not reach pipe's bottom left corner
                 bird.y + bird.height > pipe1.y) //bird's bottom left corner passes pipe's top left corner
                 return true;
        }
        return false;
    }
    public void reset() {
        pipes.clear();
    }
}
