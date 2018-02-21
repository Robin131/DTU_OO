package Check;

public class Player {
	private Color playerColor;
	private BoardPosition[] possiblePositions;
	
	
	public Player(Color color) {
		this.playerColor = color;
	}
	
	public Color getColor() {
		return this.playerColor;
	}
	
	//TODO
	public boolean moveFrom(BoardPosition oldPosition) {
		boolean flag = true;
		if(oldPosition.getPlayer() != this.playerColor)
			flag = false;
		if(this.playerColor == Color.BLACK) {
			if(Board.positions[oldPosition.getX()-1][oldPosition.getY()+1].getPlayer() == Color.WHITE
				& Board.positions[oldPosition.getX()-2][oldPosition.getY()+2].getPlayer() == Color.NONE) {
				flag = true;
				possiblePositions[0] = Board.positions[oldPosition.getX()-2][oldPosition.getY()+2];
			}
			if(Board.positions[oldPosition.getX()+1][oldPosition.getY()+1].getPlayer() == Color.WHITE
				 & Board.positions[oldPosition.getX()+2][oldPosition.getY()+2].getPlayer() == Color.NONE) {
				flag = true;
				possiblePositions[1] = Board.positions[oldPosition.getX()+2][oldPosition.getY()+2];
			}
			if(Board.positions[oldPosition.getX()-1][oldPosition.getY()+1].getPlayer() == Color.NONE) {
				flag = true;
				possiblePositions[2] = Board.positions[oldPosition.getX()-1][oldPosition.getY()+1];
			}
			if(Board.positions[oldPosition.getX()+1][oldPosition.getY()+1].getPlayer() == Color.NONE) {
				flag = true;
				possiblePositions[3] = Board.positions[oldPosition.getX()+1][oldPosition.getY()+1];
			}
			else flag = false;
		}
		else if(this.playerColor == Color.WHITE) {
			if((Board.positions[oldPosition.getX()-1][oldPosition.getY()-1].getPlayer() == Color.BLACK
					& Board.positions[oldPosition.getX()-2][oldPosition.getY()-2].getPlayer() == Color.NONE)
					|| (Board.positions[oldPosition.getX()+1][oldPosition.getY()-1].getPlayer() == Color.BLACK
						& Board.positions[oldPosition.getX()+2][oldPosition.getY()-2].getPlayer() == Color.NONE))
					flag = true;
				else if(Board.positions[oldPosition.getX()-1][oldPosition.getY()-1].getPlayer() == Color.NONE
						|| Board.positions[oldPosition.getX()+1][oldPosition.getY()-1].getPlayer() == Color.NONE)
					flag = true;
				else flag = false;
		}
		return flag;
	}
	
	//TODO
	public boolean moveTo(BoardPosition newPosition) {
		boolean flag = true;
		
		return flag;
	}
	

}
