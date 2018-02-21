package Check;

public class NormalPiece extends Piece{
	
	public NormalPiece(Position p, Color color) {
		super(p, color);
	}
	public NormalPiece(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public boolean move(Position oldPosition, Position newPosition, BoardPosition[][] p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean stepMove(Position oldPosition, Position newPosition, BoardPosition[][] p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean jump(Position oldPosition, Position newPosition, BoardPosition[][] p) {
		// TODO Auto-generated method stub
		return false;
	}

}
