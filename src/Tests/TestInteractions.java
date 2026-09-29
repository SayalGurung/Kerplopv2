package Tests;

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

    @Test
    public void TestRupees() {
        Drawable[] gameboard = new Drawable[GameEngine.BOARD_SIZE];
        Rupee rupee = new Rupee('R', "Rupee", 10, false);
        gameboard[10] = rupee;
        
        assertEquals(InteractionResult.HIT, rupee.interact(gameboard, 10));

		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, rupee.interact(gameboard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, rupee.interact(gameboard, i));
	}		

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

    @Test
    public void testWizrobeHits() {
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Wizrobe wizrobe = new Wizrobe(7);
        gameBoard[10] = wizrobe;  

        assertEquals(InteractionResult.HIT, wizrobe.interact(gameBoard, 7));

        for (int i = 0; i < 7; i++)
            assertEquals(InteractionResult.NONE, wizrobe.interact(gameBoard, i));
        for (int i = 8; i < GameEngine.BOARD_SIZE; i++)
            assertEquals(InteractionResult.NONE, wizrobe.interact(gameBoard, i));
    }

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


    