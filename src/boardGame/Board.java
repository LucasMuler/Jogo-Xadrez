package boardGame;

import Exceptions.BoardException;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows >= 1 && columns >= 1) {
			this.rows = rows;
			this.columns = columns;
			this.pieces = new Piece[rows][columns];
		} else {
			throw new BoardException("The board rows and columns need to be mor then 1");
		}

	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {

		if (positionExists(row, column)) {
			return pieces[row][column];
		} else {
			throw new BoardException("Position not on the board");
		}

	}

	public Piece piece(Position position) {

		if (positionExists(position)) {
			return pieces[position.getRow()][position.getColumn()];
		} else {
			throw new BoardException("Position not on the board");
		}
	}

	public void PlacePiece(Piece piece, Position position) {

		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;

	}

	public Piece RemovePiece(Position position) {

		if (!positionExists(position)) {
			throw new BoardException("This position is not on the board");
		} else {
			Piece aux = piece(position);
			pieces[position.getRow()][position.getColumn()] = null;
			return aux;
		}

	}

	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsAPiece(Position position) {

		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;

	}
}
