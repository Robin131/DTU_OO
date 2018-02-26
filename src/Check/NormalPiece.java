package Check;

import Check.Board.Direction;

public class NormalPiece extends Piece{
	
	public NormalPiece(Position p, Color color) {
		super(p, color);
	}
	public NormalPiece(int x, int y, Color color) {
		super(x, y, color);
	}

	public Color getNeighborColor(Direction d) {
		return Board.positions[this.getPosition().getX()][this.getPosition().getY()]
				.returnPosition(d).getPlayer();
	}
	
	@Override
	public boolean moveTo(Position newPosition) {
		boolean flag = false;
		if(this.stepMove(this.getPosition(), newPosition) || this.jump(this.getPosition(), newPosition))
			flag = true;
		return flag;
		//judge the validity of the newPosition
	}
	
	@Override
	public boolean moveFrom() {
		boolean flag = false;
		
		switch(this.getPlayerColor()){
		case BLACK:{
			//BLACK Piece move backward on the board;
			if(this.getNeighborColor(Direction.RIGHTBACK) == Color.NONE
				|| this.getNeighborColor(Direction.LEFTBACK) == Color.NONE) 
				flag = true;
			if((this.getNeighborColor(Direction.RIGHTBACK2) == Color.NONE
				& Board.returnPosition(this.getPosition(), Direction.RIGHTBACK).getPlayer() == Color.WHITE)
				|| (Board.returnPosition(this.getPosition(), Direction.LEFTBACK2).getPlayer() == Color.NONE
				  & Board.returnPosition(this.getPosition(), Direction.LEFTBACK).getPlayer() == Color.WHITE)) 
				flag = true;
			break;
		}
		case WHITE:{
			if(Board.positions[this.getPosition().getX()][this.getPosition().getY()].returnPosition(Direction.RIGHTAHEAD).getPlayer() == Color.NONE
				|| Board.returnPosition(this.getPosition(), Direction.LEFTAHEAD).getPlayer() == Color.NONE) 
				flag = true;
			if((Board.returnPosition(this.getPosition(), Direction.RIGHTAHEAD2).getPlayer() == Color.NONE
				& Board.returnPosition(this.getPosition(), Direction.RIGHTAHEAD).getPlayer() == Color.BLACK)
				|| (Board.returnPosition(this.getPosition(), Direction.LEFTAHEAD2).getPlayer() == Color.NONE
				  & Board.returnPosition(this.getPosition(), Direction.LEFTAHEAD).getPlayer() == Color.BLACK)) 
				flag = true;
			break;
		}
		case NONE:break;
		}
		//judge if the chosen piece has any way to move
		return flag;
	}
	
	@Override
	protected boolean stepMove(Position oldPosition, Position newPosition) {
		boolean flag = false;
		switch(this.getPlayerColor()) {
		case BLACK:{
			if(Board.positions[newPosition.getX()][newPosition.getY()].getPlayer() == Color.NONE
					& (newPosition.getY() == oldPosition.getY() + 1)
					 & Math.abs(newPosition.getX() - oldPosition.getX()) == 1)
				flag = true;
			break;
		}
		case WHITE:{
			if(Board.positions[newPosition.getX()][newPosition.getY()].getPlayer() == Color.NONE
					& (newPosition.getY() == oldPosition.getY() - 1)
					 & Math.abs(newPosition.getX() - oldPosition.getX()) == 1)
				flag = true;
			break;
		}
		case NONE:break;
		}

		return flag;
		//judge if the move instruction obeys one-stepMove rule
	}

	@Override
	protected boolean jump(Position oldPosition, Position newPosition) {
		boolean flag = true;
		Position middlePosition = new Position((int)(0.5 * oldPosition.getX() + 0.5 * newPosition.getX()), (int)(0.5 * oldPosition.getY() + 0.5 * newPosition.getY()));
		double distance = Math.sqrt(Math.pow(newPosition.getX() - oldPosition.getX(), 2) + Math.pow(newPosition.getY() - oldPosition.getY(), 2));
		switch(this.getPlayerColor()) {
		case BLACK: {
			if(distance == 2 * Math.sqrt(2)
					& Board.positions[middlePosition.getX()][middlePosition.getY()].getPlayer() == Color.WHITE
					 & newPosition.getY() > oldPosition.getY())
				flag = true;
			break;
		} 
		case WHITE:{
			if(distance == 2 * Math.sqrt(2)
					& Board.positions[middlePosition.getX()][middlePosition.getY()].getPlayer() == Color.BLACK
					 & newPosition.getY() < oldPosition.getY())
				flag = true;
			break;
		} 
		case NONE:break;
		}
		
		return flag;
		//judge if the move instruction obeys jump rule
	}

	public void move(Position newPosition) {
		//apply the instruction
		
		Position middlePosition = new Position((int)(0.5 * this.getPosition().getX() + 0.5 * newPosition.getX()), (int)(0.5 * this.getPosition().getY() + 0.5 * newPosition.getY()));
		//move the piece by exchange the old & new position's Color
		//change new position's color to this player on board
		Board.positions[newPosition.getX()][newPosition.getY()].setColor(this.getPlayerColor());
		//change old position's color to NONE on board
		Board.positions[this.getPosition().getX()][this.getPosition().getY()].setColor(Color.NONE);
		//if jump, eat the piece
		if(Math.abs(newPosition.getX() - this.getPosition().getX()) == 2) {
			Board.positions[middlePosition.getX()][middlePosition.getY()].setColor(Color.NONE);
		}
		//change the position in pieces[]
		this.setPosition(newPosition.getX(), newPosition.getY());

	}
}
