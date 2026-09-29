package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

/*
 * Keese moves left and right
 */
public class Keese extends GamePiece implements Moveable {
    private int direction = 1; // 1 = right. -1 = left

    public Keese(int location) {
        super('K', "Keese", location);
    }

    @Override
    public void move(Drawable[] gameBoard, int playerLocation) {
        if (gameBoard[getLocation()] == this) {
            gameBoard[getLocation()] = null;
        }

        int currentLoc = getLocation();
        int newLoc = currentLoc + direction;
        
        if (newLoc >= GameEngine.BOARD_SIZE || newLoc < 0) {
            direction *= -1;
            newLoc = currentLoc + direction;
        }

        setLocation(newLoc);
        if (newLoc >= 0 && newLoc < GameEngine.BOARD_SIZE && gameBoard[newLoc] == null) {
            gameBoard[newLoc] = this;
        }
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (getLocation() == playerLocation) {
            return InteractionResult.HIT;
        }
        return InteractionResult.NONE;
    }
}