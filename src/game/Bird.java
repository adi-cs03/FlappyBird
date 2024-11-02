package game;

import javax.swing.*;
import java.awt.*;

public class Bird {
    private static final int startX= 150;  //x coordinate of the bird on the title screen
    private static final int startY = 280; //y coordinate of the bird on the title screen
    final int width = 34, height = 24; //dimensions of the bird
    private static final int flapStrength = -9; //the upward thrust generated on click
    private static final int gravity = 1; //downward acceleration of the bird
    private static final int maxVerticalVelocity = 10; //terminal velocity
    private int verticalVelocity; //vertical verticalVelocity of the bird

    int x,y; //coordinates

    private final Image birdModel;

    Bird (){
        //setting coordinates of the bird on the title screen
        x = startX;
        y = startY;

        verticalVelocity = 0; //bird is stationary on the title screen;

        //loading the bird model
        ImageIcon image = new ImageIcon("src/assets/flappy_bird_model.png");
        birdModel = image.getImage();
    }

    //flap function to move the bird up on click
    public void flap() {
        verticalVelocity = flapStrength;
    }

    //function to change the Y-position of the bird based on velocity of the bird
    public void fall() {
        verticalVelocity += gravity; //accelerating the bird
        verticalVelocity = (verticalVelocity > maxVerticalVelocity) ? maxVerticalVelocity : verticalVelocity; //verticalVelocity should not exceed the maxVerticalVelocity
        y += verticalVelocity; //updating the position the bird according to the velocity
        y = Math.max(y , 0); //the bird should not cross the top of the window
    }

    //resetting the bird's state after game over
    public void reset() {
        x = startX;
        y = startY;
        verticalVelocity = 0;
    }

    void draw(Graphics g) {
        g.drawImage(birdModel,x, y,width, height, null);
    }

}
