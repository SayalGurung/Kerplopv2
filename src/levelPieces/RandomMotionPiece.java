package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import java.util.Random;

public abstract class RandomMotionPiece extends GamePiece implements Moveable {
    protected Random rand;

    public RandomMotionPiece(char symbol, String label, int location) {
        super(symbol, label, location);
        this.rand = new Random();
    }

    @Override
    public void move(Drawable[] gameBoard, int playerLocation) {
        // Clear current position
        if (gameBoard[getLocation()] == this) {
            gameBoard[getLocation()] = null;
        }

        int newLocation = rand.nextInt(GameEngine.BOARD_SIZE);

        // Update location
        setLocation(newLocation);
        if (gameBoard[newLocation] == null) {
            gameBoard[newLocation] = this;
        }
    }
}