package Chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;

public abstract class ChessPiece extends Piece{
	
	private Chess.Color color;
	
	/**
	 * default constructor
	 * @param board
	 * @param color
	 */
	
	public ChessPiece(Board board, Chess.Color color) {
		super(board);
		this.color = color;
	}

	public Chess.Color getColor() {
		return color;
	}
	
	/**
	 * verify if there is any piece in the given position, with that see if is 
	 * the same color as the source piece
	 * @param position
	 * @return
	 */
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
	
}
