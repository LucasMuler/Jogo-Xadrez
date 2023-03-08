package Chess.Pieces;

import Chess.ChessPiece;
import boardGame.Board;
import boardGame.Position;

public class Knight extends ChessPiece {

	public Knight(Board board, Chess.Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] PossibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		return mat;
	}

}
