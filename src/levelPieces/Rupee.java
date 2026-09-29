package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/*
 * Rupee grants the player 1 poimt when collected.
 */
public class Rupee extends GamePiece {
	private boolean obtained = false;
	
    public Rupee(int location) {
        super('R', "Rupee", location);
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
    	
    	if (obtained == false && getLocation() == playerLocation) {
    		obtained = true;
    		gameBoard[getLocation()] = null;
            return InteractionResult.GET_POINT;
        }
        return InteractionResult.NONE;
    }
}