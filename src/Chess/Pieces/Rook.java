package Chess.Pieces;

import Chess.ChessPiece;
import boardGame.Board;

public class Rook extends ChessPiece{

	public Rook(Board board, Chess.Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}
	
	@Override
	public boolean[][] PossibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
	}

}
