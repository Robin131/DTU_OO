package Check;

public abstract class Piece {
	private Position position;
	private Color playerColor;
	private int index;
	
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
	public void move(Position newPosition) {
		// change the static positions array
		Board.positions[this.position.getX()][this.position.getY()].setColor(Color.NONE);
		Board.positions[this.position.getX()][this.position.getY()].setIndex(-1);
		Board.positions[newPosition.getX()][newPosition.getY()].setColor(this.playerColor);
		Board.positions[newPosition.getX()][newPosition.getY()].setIndex(this.getIndex());
		
		//if jump then kill enemy
		if(Math.abs(newPosition.getX() - this.position.getX()) == 2) {
			Board.positions[(newPosition.getX() + this.position.getX()) / 2]
					[(newPosition.getY() + this.position.getY()) / 2].setColor(Color.NONE);
			Board.positions[(newPosition.getX() + this.position.getX()) / 2]
					[(newPosition.getY() + this.position.getY()) / 2].setIndex(-1);
		}
		
		// change position for self
		this.position.setX(newPosition.getX());
		this.position.setY(newPosition.getY());
		
		
	}
	
	
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
	
	public int getIndex() {
		return this.index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
}
