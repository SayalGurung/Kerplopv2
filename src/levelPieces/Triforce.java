package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/*
 * triforce instantly advances the player to the next levrl upon interaction
 */
public class Triforce extends GamePiece {

    public Triforce(int location) {
        super('T', "Triforce", location);
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (getLocation() == playerLocation) {
            return InteractionResult.ADVANCE;
        }
        return InteractionResult.NONE;
    }
}