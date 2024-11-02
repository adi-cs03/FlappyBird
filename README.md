# Flappy Bird

A simple implementation of the classic Flappy Bird game using Java and Swing. In this project, you can control a bird navigating through a series of pipes while trying to achieve the highest score possible. The game features dynamic scoring based on pipe passing, a simple user interface, and custom graphics. You can find the source code and assets in this repository: [Flappy Bird Repository](https://github.com/adi-cs03/FlappyBird).

## Features

- Play as a bird navigating through pipes.
- Simple and intuitive controls (press SPACE to flap).
- Dynamic scoring based on pipe passing.
- Game over state with score reset.
- Custom graphics and fonts.

## Technologies Used

- Java (JDK 8 or later)
- Java Swing for GUI
- AWT for graphics rendering

## Getting Started

To run this project on your local machine, follow these steps:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/adi-cs03/FlappyBird.git
   
2. **Navigate to the project directory:**
   ```bash
   cd FlappyBird
   
3. **Compile the Java files:** Make sure you have JDK installed and compile the Java files:
   ```bash
   javac src/game/*.java
   
4. **Run the game:** Execute the main class to start the game
   ```bash
   java -cp src game.Main

5. **Assests:** Make sure the asset files (images and fonts) are in the correct directory as specified in the code (e.g., src/assets).

## Controls
- **SPACE:** Flap the to ascend.
- The game starts when you press the SPACE key for the first time.

## Future Improvements
- Add sound effects and background music.
- Implement different levels of difficulty.
- Enhance graphics and animations.
- Include high score tracking.
