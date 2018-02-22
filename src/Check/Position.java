package Check;

public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isOnBoard() {
		boolean flag = true;
		if(this.x > 7 || this.x < 0 || this.y < 0 || this.y > 7)
			flag = false; 
		return flag;
	}
}
