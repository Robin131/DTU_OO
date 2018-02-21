package Check;

public class Board {
	private Piece pieces[];
	public static BoardPosition positions[][];
	
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
			positions[pieces[i].getPosition().getX()][p.getPosition().getY()].setColor(pieces[i].getPlayerColor());
			positions[pieces[i].getPosition().getX()][p.getPosition().getY()].setIndex(i);
		}
		
		
	}
	public boolean moveFrom(Position oldPosition, Color playerColor) {
		//first see whether there is piece for that player
		if(positions[oldPosition.getX()][oldPosition.getY()].getPlayer() != playerColor)
			return false;
		//if the piece belongs to the player
		int pieceIndex = positions[oldPosition.getX()][oldPosition.getY()].getIndex();
		return pieces[pieceIndex];
	}
	public boolean moveTo(Position oldPosition, Position newPosition) {
		
	}
	
	public static void draw() {
		
	}
	
}
