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
	
	//The public move function
	abstract public boolean moveTo(Position newPosition);
	abstract public boolean moveFrom();
	//Move by 1 step or jump
	abstract protected boolean stepMove(Position oldPosition, Position newPosition);
	abstract protected boolean jump(Position oldPosition, Position newPosition);
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
