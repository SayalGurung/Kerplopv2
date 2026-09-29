package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/*
 * Ganon is a boss piece that attacks at a distance. 
 * Kills the player if within 2 spaces
 */
public class Ganon extends GamePiece {

    public Ganon(int location) {
        super('G', "Ganon", location);
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        int distance = Math.abs(getLocation() - playerLocation);
        if (distance <= 2) {
            return InteractionResult.KILL;
        }
        return InteractionResult.NONE;
    }
}