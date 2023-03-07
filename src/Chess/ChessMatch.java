 package Chess;

import Chess.Pieces.King;
import Chess.Pieces.Rook;
import Exceptions.ChessException;
import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;

/**
 * makes some rules of a chess match
 * @author lucas
 *
 */

public class ChessMatch {

	private Board board;
	
	/**
	 * default constructor
	 */
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	public Board getBoard() {
		return board;
	}

	/**
	 * return a matrix of the position off each piece 
	 * @return
	 */
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	/**
	 * takes the source position and see what movements are possible to make,
	 * with the rules of the piece.
	 * @param sourcePosition
	 * @return
	 */
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).PossibleMoves();
		
	}
	
	/**
	 * this is the center off the code, this gets two positions, source and target whit
	 * this are made some validations and makes the move.
	 * @param sourcePosition
	 * @param targetPosition
	 * @return
	 */
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece)capturedPiece;
	}
	
	/**
	 * this method turns the source position to null and copy the deleted piece to a new position
	 * @param source
	 * @param target
	 * @return
	 */
	private Piece makeMove(Position source, Position target) {
		Piece p = board.RemovePiece(source);
		Piece capturedPiece = board.RemovePiece(target);
		board.PlacePiece(p, target);
		return capturedPiece;
	}

	
	/**
	 * verifies if there is a piece in source position and if are any possible movement 
	 * @param position
	 */
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece in source position");		
		} 
		else if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	/**
	 * gets the source and target position to verify if there is any possible move 
	 * @param source
	 * @param target
	 */
	
	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	/**
	 * place a new piece in the positions that are given to this method
	 * @param column
	 * @param row
	 * @param piece
	 */

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.PlacePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	/**
	 * makes in the terminal a initial setup of the position and pieces
	 */
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
	
}
