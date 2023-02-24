package Chess;

import Chess.Pieces.Knight;
import Chess.Pieces.Rook;
import boardGame.Board;
import boardGame.Position;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	public Board getBoard() {
		return board;
	}

	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	private void initialSetup() {
		board.PlacePiece(new Rook(board, Chess.Color.WHITE), new Position(3, 1));
		board.PlacePiece(new Knight(board, Chess.Color.BLACK), new Position(0 , 4));
		board.PlacePiece(new Knight(board, Chess.Color.BLACK), new Position(7 , 4));
	}
	
}
