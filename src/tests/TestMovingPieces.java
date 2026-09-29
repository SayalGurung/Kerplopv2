package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.Pot;
import levelPieces.Wizrobe;



public class TestMovingPieces {

    @Test
    public void testRandomMovement() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        //start with 1 and leaves 0 open
        for (int i =0; i <=5; i++){
            gameBoard[i] = new Pot();
        }
        //this leaves 7 open
        for (int i =7; i <=11 i++){
            gameBoard[i] = new Pot();
        }
        //this  leaves 12, 13, and 20 open while assuming player is in 13
        for (int i =14; i <=20; i++){
            gameBoard[i] = new Pot();
        }

        Wizrobe wizrobe = new Wizrobe(6);
        gameBoard[6] = wizrobe;
        int count0 = 0;
        int count6 = 0;
        int count12 = 0;
        int count20 = 0;
        for (int i = 0; i < 200; i++) {
            wizrobe.move(gameBoard,13);
            int Location = wizrobe.getLocation();
            if (location != 0 && location != 6 && location != 12 && location != 20) {
                fail("Wizrobe moved to an invalid location: " + location);
            }
            if (location == 0) {
                count0++;
            }
            if (location == 6) {
                count6++;
            }
            if (location == 12) {
                count12++;
            }
            if (location == 20) {
                count20++;
            }
        }
        //ensures that each option is randomly chosen
        assertTrue(count0 > 0);
        assertTrue(count6 > 0);
        assertTrue(count12 > 0);
        assertTrue(count20 > 0);
       
    }


    @Test 
	public void testKeeseMovement() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		int last = GameEngine.BOARD_SIZE - 1;
		Keese keese = new Keese(18);
		gameBoard[18] = keese;
 
		// Moves right until it reaches the end of the board
		keese.move(gameBoard, 5);
		assertEquals(19, keese.getLocation());
		assertNull(gameBoard[18]);
		assertSame(keese, gameBoard[19]);
 
		keese.move(gameBoard, 5);
		assertEquals(last, keese.getLocation());
		assertNull(gameBoard[19]);
		assertSame(keese, gameBoard[last]);
 
		// Moves Keese left because it is at the edge of the board
		keese.move(gameBoard, 5);
		assertEquals(last - 1, keese.getLocation());
		assertSame(keese, gameBoard[last - 1]);
		assertNull(gameBoard[last]);
 
		// Keeps going leftuntil it reaches 0
		for (int i = 0; i < last - 1; i++)
			keese.move(gameBoard, 5);
		assertEquals(0, keese.getLocation());
		assertSame(keese, gameBoard[0]);
 
		// Moves Keese right because it is at the edge of the board
		keese.move(gameBoard, 5);
		assertEquals(1, keese.getLocation());
		assertSame(keese, gameBoard[1]);
		assertNull(gameBoard[0]);
	}

}