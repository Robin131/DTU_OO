package Check;

enum Color{
	WHITE(), BLACK(), NONE();
}

public class BoardPosition extends Position{
	
	private Color playerColor;
	private int index;
	public enum Direction{
		LeftAhead(-1, -1), LeftBack(-1, 1), RightAhead(1, -1), RightBack(1, 1);
		int deltaX, deltaY;
		private Direction(int deltaX, int deltaY){
			this.deltaX = deltaX;
			this.deltaY = deltaY;
		}
	}
	
	public BoardPosition returnPosition(Direction d) {
		BoardPosition p_new = new BoardPosition(0,0);
		p_new.setX(this.getX() + d.deltaX);
		p_new.setY(this.getY() + d.deltaY);
		p_new.setColor(positions[p_new.getX()][p_new.getY()].playerColor);
		return p_new;
	}
	
	public BoardPosition(int x, int y, Color color, int index) {
		super(x, y);
		this.playerColor = color;
		this.index = index;
	}
	
	public BoardPosition(int x, int y) {
		super(x, y);
		this.playerColor = Color.NONE;
	}
	
	public Color getPlayer() {
		return this.playerColor;
	}
	
	public void setColor(Color color) {
		this.playerColor = color;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
}
