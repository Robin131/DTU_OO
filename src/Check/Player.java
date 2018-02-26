package Check;

public class Player {
	private Color playerColor;
	
	public Player(Color color) {
		this.playerColor = color;
	}
	
	public Color getColor() {
		return this.playerColor;
	}
	
	public boolean moveFrom(Position oldPosition, Board board, Color playerColor) {
		return board.moveFrom(oldPosition, playerColor);
	}
	
	public boolean moveTo(Position oldPosition, Position newPosition, Board board, Color playerColor) {
		return board.moveTo(oldPosition, newPosition);
	}

}
