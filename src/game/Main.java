package game;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //create the game frame
        JFrame frame = new JFrame("Flappy Bird");
        Game gamePanel = new Game();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); //prevent resizing
        ImageIcon icon = new ImageIcon("src/assets/flappy_bird_icon.png"); //importing the icon image
        frame.setIconImage(icon.getImage()); //setting the icon for the frame
        frame.add(gamePanel); //add the game panel to the frame
        frame.pack(); //adjust the frame size to fit the preferred size of the panel
        frame.setLocationRelativeTo(null); //center the frame on the screen
        gamePanel.requestFocus();
        frame.setVisible(true); //show the frame
    }
}
