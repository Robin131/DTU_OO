package Check;

enum Color{
	WHITE(), BLACK(), NONE();
}

public class BoardPosition extends Position{
	
	private Color playerColor;
	private int index;
	
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
