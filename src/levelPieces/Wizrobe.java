package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/*
 * Wizrobe teleports randomly across the board using RandomMotionPiece logic.
 * Hits the player if the player moves onto its square.
 */
public class Wizrobe extends RandomMotionPiece {

    public Wizrobe(int location) {
        super('W', "Wizrobe", location);
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (getLocation() == playerLocation) {
            return InteractionResult.HIT;
        }
        return InteractionResult.NONE;
    }
}