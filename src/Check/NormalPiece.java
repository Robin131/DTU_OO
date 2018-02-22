package Check;

import Check.Position.Direction;

public class NormalPiece extends Piece{
	
	public NormalPiece(Position p, Color color) {
		super(p, color);
	}
	public NormalPiece(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public boolean moveTo(Position newPosition) {
		
		return false;
	}

	@Override
	public boolean moveFrom() {
		switch(this.getPlayerColor()){
		case Color.BLACK:{
			if(this.getPosition().returnPosition(Direction.RightBack) == Color.NONE)
		}
		}
		return false;
	}
	
	@Override
	protected boolean stepMove(Position oldPosition, Position newPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean jump(Position oldPosition, Position newPosition) {
		// TODO Auto-generated method stub
		return false;
	}

}
