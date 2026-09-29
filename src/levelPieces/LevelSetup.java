package levelPieces;

import gameEngine.GameEngine;
import gameEngine.Drawable;
import gameEngine.Moveable;
import java.util.ArrayList;

public class LevelSetup {
	private Drawable[] board;
	private ArrayList<GamePiece> pieces;
	private ArrayList<Moveable> movingPieces;
	private int playerStartLoc;
	
	public LevelSetup() {
        board = new Drawable[GameEngine.BOARD_SIZE];
        movingPieces = new ArrayList<>();
        pieces = new ArrayList<>();
        playerStartLoc = 10;
    }
	
	public void createLevel(int levelNum) {
		board = new Drawable[GameEngine.BOARD_SIZE];
        movingPieces.clear();
        pieces.clear();
        
        if (levelNum == 1) {
            playerStartLoc = 10;

            Pot pot = new Pot();
            board[2] = pot;

            Rupee rupee1 = new Rupee(5);
            board[5] = rupee1;
            pieces.add(rupee1);
            
            Rupee rupee2 = new Rupee(14);
            board[14] = rupee2;
            pieces.add(rupee2);

            Moblin moblin = new Moblin(8);
            board[8] = moblin;
            pieces.add(moblin);

            Keese keese = new Keese(13);
            board[13] = keese;
            movingPieces.add(keese);
            pieces.add(keese);

            Wizrobe wizrobe = new Wizrobe(15);
            board[15] = wizrobe;
            movingPieces.add(wizrobe);
            pieces.add(wizrobe);

            Triforce triforce = new Triforce(19);
            board[19] = triforce;
            pieces.add(triforce);

        } else if (levelNum == 2) {
            playerStartLoc = 10;

            Pot pot = new Pot();
            board[2] = pot;

            Rupee rupee1 = new Rupee(5);
            board[5] = rupee1;
            pieces.add(rupee1);

            Rupee rupee2 = new Rupee(17);
            board[17] = rupee2;
            pieces.add(rupee2);
            
            Triforce triforce = new Triforce(20);
            board[20] = triforce;
            pieces.add(triforce);

            Keese keese = new Keese(8);
            board[8] = keese;
            movingPieces.add(keese);
            pieces.add(keese);

            Wizrobe wizrobe = new Wizrobe(15);
            board[15] = wizrobe;
            movingPieces.add(wizrobe);
            pieces.add(wizrobe);

            Ganon ganon = new Ganon(18);
            board[18] = ganon;
            pieces.add(ganon);
        }
	}
	
	public Drawable[] getBoard() {
        return board;
    }

    public ArrayList<Moveable> getMovingPieces() {
        return movingPieces;
    }

    public ArrayList<GamePiece> getInteractingPieces() {
        return pieces;
    }

    public int getPlayerStartLoc() {
        return playerStartLoc;
    }
}
