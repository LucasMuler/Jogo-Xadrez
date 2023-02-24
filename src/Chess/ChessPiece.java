package Chess;

import boardGame.Board;
import boardGame.Piece;

public class ChessPiece extends Piece{
	
	private Chess.Color color;
	
	public ChessPiece(Board board, Chess.Color color) {
		super(board);
		this.color = color;
	}

	public Chess.Color getColor() {
		return color;
	}
	
}
