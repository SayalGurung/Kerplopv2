package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/*
 *  Moblin strikes the player if on the same or adjacent space.

 */
public class Moblin extends GamePiece {

    public Moblin(int location) {
        super('M', "Moblin", location);
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        int distance = Math.abs(getLocation() - playerLocation);
        if (distance <= 1) {
            return InteractionResult.HIT;
        }
        return InteractionResult.NONE;
    }
}