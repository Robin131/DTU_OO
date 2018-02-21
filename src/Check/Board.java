package Check;

public class Board {
	private Piece pieces[];
	public static BoardPosition positions[][];
	
	public Board() {
		initialPieces();
		initialBoardPosition();
	}
	
	//TODO
	private void initialPieces() {
		pieces = new NormalPiece[24];
		pieces[0] = new NormalPiece(1, 0, Color.BLACK);
	}
	
	private void initialBoardPosition() {
		positions = new BoardPosition[8][8];
		for(int i = 0; i <=7; i++) {
			for(int j = 0; j <= 7; j++) {
				//TODO
			}
		}
		
		//
		
		
	}
	
	//TODO
	public boolean moveTo(Position oldPosition, Position newPosition) {
		
	}
	
	//TODO
	public boolean moveFrom(Position oldPosition) {
		
	}
	
	
	
}
