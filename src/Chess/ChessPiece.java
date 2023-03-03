package Chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;

public abstract class ChessPiece extends Piece{
	
	private Chess.Color color;
	
	public ChessPiece(Board board, Chess.Color color) {
		super(board);
		this.color = color;
	}

	public Chess.Color getColor() {
		return color;
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
	
}
