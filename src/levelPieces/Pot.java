package levelPieces;

import gameEngine.Drawable;

/*
 * Pot does nothing 
 */
public class Pot implements Drawable {
    private char symbol;

    public Pot() {
        this.symbol = 'U'; // Symbol for pot
    }

    @Override
    public void draw() {
        System.out.print(symbol);
    }
}