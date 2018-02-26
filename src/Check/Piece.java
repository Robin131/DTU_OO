package Check;

abstract class Piece {
	private Position position;
	private Color playerColor;
	
	public Piece(Position p, Color color) {
		this.position = new Position(p.getX(), p.getY());
		this.playerColor = color;
	}
	
	public Piece(int x, int y, Color color) {
		this.position = new Position(x, y);
		this.playerColor = color;
	}
	
	// Judge whether this piece can move to the new position
	abstract public boolean moveTo(Position newPosition);
	// Judge whether this piece can move from the new position
	abstract public boolean moveFrom();
	// Judge whether this piece can be moved by only 1 step
	abstract protected boolean stepMove(Position oldPosition, Position newPosition);
	// Judge whether this piece can jump
	abstract protected boolean jump(Position oldPosition, Position newPosition);
	// move the piece to the new position
	abstract public void move(Position newPosition);
	
	
	public Position getPosition() {
		return (new Position(this.position.getX(), this.position.getY()));
	}
	
	public void setPosition(int x, int y) {
		this.position.setX(x);
		this.position.setY(y);
	}
	
	public Color getPlayerColor() {
		return this.playerColor;
	}
}
