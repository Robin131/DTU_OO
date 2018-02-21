package Check;

public class Position {
	private int x;
	private int y;
	public enum Direction{
		LeftAhead(-1, -1), LeftBack(-1, 1), RightAhead(1, -1), RightBack(1, 1);
		int deltaX, deltaY;
		private Direction(int deltaX, int deltaY){
			this.deltaX = deltaX;
			this.deltaY = deltaY;
		}
	}
	
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
