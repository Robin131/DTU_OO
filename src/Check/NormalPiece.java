package Check;

import Check.Board.Direction;

public class NormalPiece extends Piece{
	
	public NormalPiece(Position p, Color color) {
		super(p, color);
	}
	public NormalPiece(int x, int y, Color color) {
		super(x, y, color);
	}

	// get the color of a specific direction
	public Color getNeighborColor(Direction d) {
		try {
			return Board.positions[this.getPosition().getX()][this.getPosition().getY()]
					.returnPosition(d).getPlayer();
		} catch(ArrayIndexOutOfBoundsException e) {
			return Color.INVALID;
		}
	}
	
	// get the position of a specific direction
	public Position getNeighborPosition(Direction d) {
		try {
			return Board.positions[this.getPosition().getX()][this.getPosition().getY()].returnPosition(d);
		} catch(ArrayIndexOutOfBoundsException e) {
			return new Position(-1, -1);
		}
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
			if(getNeighborColor(Direction.RIGHTBACK) == Color.NONE || getNeighborColor(Direction.LEFTBACK) == Color.NONE) 
				flag = true;
			if((getNeighborColor(Direction.RIGHTBACK2) == Color.NONE && getNeighborColor(Direction.RIGHTBACK) == Color.WHITE)
				|| (getNeighborColor(Direction.LEFTBACK2) == Color.NONE && getNeighborColor(Direction.LEFTBACK) == Color.WHITE)) 
				flag = true;
			break;
		}
		case WHITE:{
			if(getNeighborColor(Direction.RIGHTAHEAD) == Color.NONE || getNeighborColor(Direction.LEFTAHEAD) == Color.NONE) 
				flag = true;
			if((getNeighborColor(Direction.RIGHTAHEAD2) == Color.NONE && getNeighborColor(Direction.RIGHTAHEAD) == Color.BLACK)
				|| (getNeighborColor(Direction.LEFTAHEAD2) == Color.NONE && getNeighborColor(Direction.LEFTAHEAD) == Color.BLACK)) 
				flag = true;
			break;
		}
		case NONE:break;
		default: break;
		}
		//judge if the chosen piece has any way to move
		return flag;
	}
	
	@Override
	protected boolean stepMove(Position oldPosition, Position newPosition) {
		// check whether the new position is an available one
		switch(this.getPlayerColor()) {
		case BLACK:
			if(getNeighborPosition(Direction.LEFTBACK).equals(newPosition) 
				|| getNeighborPosition(Direction.RIGHTBACK).equals(newPosition)) 
				return true;
			break;
		case WHITE:
			if(getNeighborPosition(Direction.LEFTAHEAD).equals(newPosition) 
					|| getNeighborPosition(Direction.RIGHTAHEAD).equals(newPosition)) 
					return true;
				break;
		case NONE: break;
		default : break;
		}

		return false;
		//judge if the move instruction obeys one-stepMove rule
	}

	@Override
	protected boolean jump(Position oldPosition, Position newPosition) {
		switch(this.getPlayerColor()) {
		case BLACK: 
			if((getNeighborPosition(Direction.LEFTBACK2).equals(newPosition) 
						&& getNeighborColor(Direction.LEFTBACK) == Color.WHITE)
				|| getNeighborPosition(Direction.RIGHTBACK2).equals(newPosition) 
						&& getNeighborColor(Direction.RIGHTBACK) == Color.WHITE)
				return true;
			break; 
		case WHITE:
			if((getNeighborPosition(Direction.LEFTAHEAD2).equals(newPosition) 
					&& getNeighborColor(Direction.LEFTAHEAD) == Color.BLACK)
			|| getNeighborPosition(Direction.RIGHTAHEAD2).equals(newPosition) 
					&& getNeighborColor(Direction.RIGHTAHEAD) == Color.BLACK)
			return true;
			break; 
		case NONE:break;
		default: break;
		}
		
		return false;
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
