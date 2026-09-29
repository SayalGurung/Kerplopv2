package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Ganon;
import levelPieces.Keese;
import levelPieces.Moblin;
import levelPieces.Rupee;
import levelPieces.Triforce;
import levelPieces.Wizrobe;


public class TestInteractions {
    //Testing if Rupee give point only gives a point whenthe player is standing on it, and does nothing otherwise
    @Test
    public void TestRupees() {
        Drawable[] gameboard = new Drawable[GameEngine.BOARD_SIZE];
        Rupee rupee = new Rupee(10);
        gameboard[10] = rupee;
        
        assertEquals(InteractionResult.HIT, rupee.interact(gameboard, 10));

		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, rupee.interact(gameboard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, rupee.interact(gameboard, i));
	}		
    //test if the Moblin only hits its own square and the squares directly adjacent to it but not anywhere else
    @Test
    public void testMoblinHits() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Moblin moblin = new Moblin(10);
        gameBoard[10] = moblin;

        assertEquals(InteractionResult.HIT, moblin.interact(gameBoard, 10));
        assertEquals(InteractionResult.HIT, moblin.interact(gameBoard, 9));
        assertEquals(InteractionResult.HIT, moblin.interact(gameBoard, 11));

        for (int i = 0; i < 9; i++)
            assertEquals(InteractionResult.NONE, moblin.interact(gameBoard, i));
        for (int i = 12; i < GameEngine.BOARD_SIZE; i++)
            assertEquals(InteractionResult.NONE, moblin.interact(gameBoard, i));
    }
    //test if the Keese only hits its own square but not anywhere else
    @Test
    public void testKeeseHits() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Keese keese = new Keese(10);
        gameBoard[10] = keese;  

        assertEquals(InteractionResult.HIT, keese.interact(gameBoard, 10));

        for (int i = 0; i < 10; i++)
            assertEquals(InteractionResult.NONE, keese.interact(gameBoard, i));
        for (int i = 11; i < GameEngine.BOARD_SIZE; i++)
            assertEquals(InteractionResult.NONE, keese.interact(gameBoard, i));
    }
    //test if the Wizrobe only hits its own square but not anywhere else
    @Test
    public void testWizrobeHits() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Wizrobe wizrobe = new Wizrobe(7);
        gameBoard[7] = wizrobe;  

        assertEquals(InteractionResult.HIT, wizrobe.interact(gameBoard, 7));

        for (int i = 0; i < 7; i++)
            assertEquals(InteractionResult.NONE, wizrobe.interact(gameBoard, i));
        for (int i = 8; i < GameEngine.BOARD_SIZE; i++)
            assertEquals(InteractionResult.NONE, wizrobe.interact(gameBoard, i));
    }
    //test Triforce advances the player only when the player is located on the same square as the Triforce
	@Test
	public void TestTriforceAdvances() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Triforce triforce = new Triforce(19);
		gameBoard[19] = triforce;

		assertEquals(InteractionResult.ADVANCE, triforce.interact(gameBoard, 19));
		for (int i = 0; i < 19; i++)
			assertEquals(InteractionResult.NONE, triforce.interact(gameBoard, i));
		assertEquals(InteractionResult.NONE, triforce.interact(gameBoard, 20));
	}
    //tests if Ganon kills the players on its own square and the square directly adjacent
    @Test
	public void testGanonKills() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Ganon ganon = new Ganon(10);
		gameBoard[10] = ganon;

		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (i >= 8 && i <= 12)
				assertEquals(InteractionResult.KILL, ganon.interact(gameBoard, i), "Expected KILL at " + i);
			else
				assertEquals(InteractionResult.NONE, ganon.interact(gameBoard, i), "Expected NONE at " + i);
		}
	}
    }


    