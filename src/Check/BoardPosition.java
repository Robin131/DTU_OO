package Check;

import Check.Board.Direction;

enum Color{
	WHITE("2"), BLACK("1"), NONE(" ");
	String num = null;
	private Color(String num) {
		this.num = num;
	}
	public String getPlayerNum() {
		return num;
	}
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
	
	
	// return the info of the specific direction of the position 
	public BoardPosition returnPosition(Direction d) {

		return(Board.positions[this.getX() + d.deltaX][this.getY() + d.deltaY]);
	}
	
}
