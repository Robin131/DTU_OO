package Check;

enum Color{
	WHITE(), BLACK(), NONE();
	
	/*private int name;
	private Color(int name) {
		this.name = name;
	}
	public int getPlayerNum() {
		return this.name;
	}*/
}

public class BoardPosition extends Position{
	
	private Color playerColor;
	
	
	public BoardPosition(int x, int y, Color color) {
		super(x, y);
		this.playerColor = color;
	}
	
	public BoardPosition(int x, int y) {
		super(x, y);
		this.playerColor = Color.NONE;
	}
	
	public Color getPlayer() {
		return this.playerColor;
	}
	
}
