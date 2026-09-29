package Tests;

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

        for (int i =0; i <=5; i++){
            gameBoard[i] = new Pot();
        }

        for (int i =7; i <=11 i++){
            gameBoard[i] = new Pot();
        }

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
    

}