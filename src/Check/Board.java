package Check;

public class Board {
	private Piece pieces[];
	public static BoardPosition positions[][];
	// define 8 directions to simplify the code 
	public enum Direction{
		LEFTAHEAD(-1, -1), LEFTBACK(-1, 1), RIGHTAHEAD(1, -1), RIGHTBACK(1, 1), 
		LEFTAHEAD2(-2, -2), LEFTBACK2(-2, 2), RIGHTAHEAD2(2, -2), RIGHTBACK2(2, 2);
		int deltaX, deltaY;
		private Direction(int deltaX, int deltaY){
			this.deltaX = deltaX;
			this.deltaY = deltaY;
		}
	}
	
	public Board() {
		initialPieces();
		initialBoardPosition();
	}
	
	//1-BLACK; 2-WHITE;
	private void initialPieces() {
		pieces = new NormalPiece[24];
		pieces[0] = new NormalPiece(1, 0, Color.BLACK);
		pieces[1] = new NormalPiece(3, 0, Color.BLACK);
		pieces[2] = new NormalPiece(5, 0, Color.BLACK);
		pieces[3] = new NormalPiece(7, 0, Color.BLACK);
		pieces[4] = new NormalPiece(0, 1, Color.BLACK);
		pieces[5] = new NormalPiece(2, 1, Color.BLACK);
		pieces[6] = new NormalPiece(4, 1, Color.BLACK);
		pieces[7] = new NormalPiece(6, 1, Color.BLACK);
		pieces[8] = new NormalPiece(1, 2, Color.BLACK);
		pieces[9] = new NormalPiece(3, 2, Color.BLACK);
		pieces[10] = new NormalPiece(5, 2, Color.BLACK);
		pieces[11] = new NormalPiece(7, 2, Color.BLACK);
		pieces[12] = new NormalPiece(0, 5, Color.WHITE);
		pieces[13] = new NormalPiece(2, 5, Color.WHITE);
		pieces[14] = new NormalPiece(4, 5, Color.WHITE);
		pieces[15] = new NormalPiece(6, 5, Color.WHITE);
		pieces[16] = new NormalPiece(1, 6, Color.WHITE);
		pieces[17] = new NormalPiece(3, 6, Color.WHITE);
		pieces[18] = new NormalPiece(5, 6, Color.WHITE);
		pieces[19] = new NormalPiece(7, 6, Color.WHITE);
		pieces[20] = new NormalPiece(0, 7, Color.WHITE);
		pieces[21] = new NormalPiece(2, 7, Color.WHITE);
		pieces[22] = new NormalPiece(4, 7, Color.WHITE);
		pieces[23] = new NormalPiece(6, 7, Color.WHITE);
		
		for(int i = 0; i<= 23; i++) {
			pieces[i].setIndex(i);
		}
		
	}
	private void initialBoardPosition() {
		positions = new BoardPosition[8][8];
		// first initial all the position to NONE
		for(int i = 0; i <=7; i++) {
			for(int j = 0; j <= 7; j++) {
				positions[i][j] = new BoardPosition(i, j);
			}
		}
		// change the color for every position with a piece
		for(int i = 0; i <= 23; i++) {
			positions[pieces[i].getPosition().getX()][pieces[i].getPosition().getY()].setColor(pieces[i].getPlayerColor());
			positions[pieces[i].getPosition().getX()][pieces[i].getPosition().getY()].setIndex(i);
		}
		
	}
	//check whether the oldPosition is on board and whether it holds the piece from the player 
	public boolean moveFrom(Position oldPosition, Color playerColor) {
		boolean flag = true;
		if(!oldPosition.isOnBoard())
			flag = false;
		else if(positions[oldPosition.getX()][oldPosition.getY()].getPlayer() != playerColor)
			flag = false;
		return flag;
	}
	//check whether the newPosition is on board and whether the position is empty
	public boolean moveTo(Position oldPosition, Position newPosition) {
		boolean flag = true;
		if(!newPosition.isOnBoard())
			flag = false;
		else if(positions[newPosition.getX()][newPosition.getY()].getPlayer() != Color.NONE)
			flag = false;
		return flag;
		
	}
	// return the piece on that position
	public Piece getPiece(Position oldPosition) {
		int pieceIndex = positions[oldPosition.getX()][oldPosition.getY()].getIndex();
		return pieces[pieceIndex];
		//According oldPosition to pick up a piece
	} 	
	// draw the board
	public void draw() {
		String xAxis = "    0 1 2 3 4 5 6 7      <- X axis\n";
		String frameTop = "   +----------------+\n";
		String frameBottom = "   +----------------+\n    0 1 2 3 4 5 6 7  \n";
		System.out.print(xAxis + frameTop);
		for(int i = 0; i <= 7; i++) {
			System.out.print(" " + i + " |");
			for(int j = 0; j <= 7; j++) {
				System.out.print(positions[j][i].getPlayer().getPlayerNum() + " ");
			}
			System.out.print("|\n");
		}
		System.out.print(frameBottom);
	}
}
